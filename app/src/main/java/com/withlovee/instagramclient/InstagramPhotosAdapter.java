package com.withlovee.instagramclient;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.makeramen.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by vee on 2/17/15.
 */
public class InstagramPhotosAdapter extends ArrayAdapter<InstagramPhoto> {

    private String heart;

    // Data to pass in
    // Contect, DataSource
    public InstagramPhotosAdapter(Context context, List<InstagramPhoto> objects) {
        super(context, android.R.layout.simple_list_item_1, objects);
        this.heart = context.getResources().getString(R.string.heart_c);
    }

    // Use template
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get data
        InstagramPhoto photo = getItem(position);

        // Check if we're using a recycled view, or inflate
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo, parent, false);
        }

        // Get view
        TextView tvCaption = (TextView) convertView.findViewById(R.id.tvCaption);
        ImageView ivPhoto = (ImageView) convertView.findViewById(R.id.ivPhoto);
        TextView tvUser = (TextView) convertView.findViewById(R.id.tvUser);
        TextView tvLikes = (TextView) convertView.findViewById(R.id.tvLikes);
        RoundedImageView ivUser = (RoundedImageView) convertView.findViewById(R.id.ivUser);

        // Insert model into view
        tvCaption.setText(photo.caption);
        tvUser.setText(photo.username);
        tvLikes.setText(Html.fromHtml(heart) + "  " + Integer.toString(photo.likesCount) + " likes");

        // Clear out image
        ivPhoto.setImageResource(0);
        ivUser.setImageResource(0);

        // Insert image using Picasso
        Picasso.with(getContext()).load(photo.imageUrl).into(ivPhoto);
        Picasso.with(getContext()).load(photo.usernameImage).fit().into(ivUser);

        // Return the created item as a view
        return convertView;
    }
}
