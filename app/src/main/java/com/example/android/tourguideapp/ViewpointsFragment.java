package com.example.android.tourguideapp;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.android.tourguideapp.databinding.AttractionListBinding;

import java.util.ArrayList;

public class ViewpointsFragment extends Fragment {

    public ViewpointsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        AttractionListBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.attraction_list, container, false);

        ArrayList<Attraction> attractions = new ArrayList<>();

        attractions.add(new Attraction(getString(R.string.penitent_bridge),
                getString(R.string.penitent_bridge_desc), R.drawable.placeholder));

        AttractionAdapter adapter =
                new AttractionAdapter(getActivity(), attractions);
        binding.list.setAdapter(adapter);
        binding.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                resize listitem when clicked
                ViewGroup.LayoutParams params = view.getLayoutParams();
                int wrapContent = ViewGroup.LayoutParams.MATCH_PARENT;
                int normalHeight = getResources().getDimensionPixelSize(R.dimen.list_item_height);
                params.height = params.height == normalHeight ? wrapContent : normalHeight;
                view.setLayoutParams(params);
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
