package com.example.plantonic;

import static androidx.core.view.ViewCompat.setTransitionName;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.Image;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class adapter_home extends RecyclerView.Adapter<adapter_home.viewHolder> {
    Context context;
    public adapter_home(Context cnt){
        context = cnt;
    }
    @NonNull
    @Override
    public adapter_home.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.recycler_list_view, viewGroup, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter_home.viewHolder viewHolder, @SuppressLint("RecyclerView") int i) {
        viewHolder.imageView.setTransitionName("plant_image " + i);

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity appCompatActivity = (AppCompatActivity) view.getContext();
                Fragment plantView = new plant_view();
                System.out.println("plant_image " + i);
                plantView.setSharedElementEnterTransition(TransitionInflater.from(context).inflateTransition(R.transition.shared_image));
                plantView.setEnterTransition(TransitionInflater.from(context).inflateTransition(android.R.transition.fade));
                plantView.setReturnTransition(TransitionInflater.from(context).inflateTransition(android.R.transition.fade));
                appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.framel, plantView)
                        .addSharedElement(viewHolder.imageView, "plant_image")
                        .addToBackStack(null)
                        .commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_main);
            imageView = itemView.findViewById(R.id.imageView5);
        }
    }
}
