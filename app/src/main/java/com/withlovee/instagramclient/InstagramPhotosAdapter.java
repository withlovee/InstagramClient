package com.withlovee.instagramclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by vee on 2/17/15.
 */
public class InstagramPhotosAdapter extends ArrayAdapter<InstagramPhoto> {

    // Data to pass in
    // Contect, DataSource
    public InstagramPhotosAdapter(Context context, List<InstagramPhoto> objects) {
        super(context, android.R.layout.simple_list_item_1, objects);
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

        // Insert model into view
        tvCaption.setText(photo.caption);

        // Clear out image
        ivPhoto.setImageResource(0);

        // Insert image using Picasso
        Picasso.with(getContext()).load(photo.imageUrl).into(ivPhoto);

        // Return the created item as a view
        return convertView;
    }
}
