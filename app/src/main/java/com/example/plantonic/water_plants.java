package com.example.plantonic;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class water_plants extends Fragment{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.water_plants, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerw);
        adapter_water adapterWater = new adapter_water(getContext());
        recyclerView.setAdapter(adapterWater);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Button addplant = view.findViewById(R.id.addp);
        addplant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return view;

    }
}