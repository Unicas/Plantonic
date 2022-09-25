package com.example.plantonic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
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
    public void onBindViewHolder(@NonNull adapter_home.viewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        public viewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
