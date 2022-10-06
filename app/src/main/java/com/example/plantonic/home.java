package com.example.plantonic;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class home extends Fragment{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        postponeEnterTransition();

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        adapter_home adapterHome = new adapter_home(getContext());
        recyclerView.setAdapter(adapterHome);
        Transition transition = TransitionInflater.from(requireContext())
                .inflateTransition(android.R.transition.slide_left);
        setEnterTransition(transition);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Button addplant = view.findViewById(R.id.addp);

        view
                .getViewTreeObserver()
                .addOnGlobalLayoutListener(
                        new ViewTreeObserver.OnGlobalLayoutListener() {
                            @Override
                            public void onGlobalLayout() {
                                startPostponedEnterTransition();
                                recyclerView
                                        .getViewTreeObserver()
                                        .removeOnGlobalLayoutListener(this);
                            }
                        });
        addplant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return view;

    }
}