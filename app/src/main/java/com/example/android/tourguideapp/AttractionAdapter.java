package com.example.android.tourguideapp;


import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.android.tourguideapp.databinding.ListItemBinding;

import java.util.ArrayList;


/**
 *
 */

public class AttractionAdapter extends ArrayAdapter<Attraction> {

    AttractionAdapter(Activity context, ArrayList<Attraction> attractions) {
        super(context, 0, attractions);
    }

    @Override
    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        ListItemBinding binding;
        if (listItemView == null) {
            binding = DataBindingUtil.inflate(
                    LayoutInflater.from(getContext()),
                    R.layout.list_item, parent, false);
            listItemView = binding.getRoot();
        } else {
            binding = (ListItemBinding) listItemView.getTag();
        }

        // Get the {@link Attraction} object located at this position in the list
        Attraction currentAttraction = getItem(position);

        binding.name.setText(currentAttraction.getName());
        binding.description.setText(currentAttraction.getDescription());
        binding.image.setImageResource(currentAttraction.getImageResourceId());
        listItemView.setTag(binding);


        return listItemView;
    }
}
