package com.example.sqliteassethelperapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DbAdapter extends RecyclerView.Adapter<DbAdapter.DbViewHolder> {

    ArrayList<DbModelClass> objectDbModelClassArrayList;
    public DbAdapter(ArrayList<DbModelClass> objectDbModelClassArrayList){
        this.objectDbModelClassArrayList=objectDbModelClassArrayList;
    }
    @NonNull
    @Override
    public DbViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View singleRow= LayoutInflater .from(parent.getContext())
                .inflate(R.layout.single_row,parent,false);
        return new DbViewHolder(singleRow);
    }

    @Override
    public void onBindViewHolder(@NonNull DbViewHolder holder, int position) {
        DbModelClass objectDbModelClass=objectDbModelClassArrayList.get(position);
        holder.imageDesTV.setText(objectDbModelClass.getImageDes());
        holder.ourImageTV.setImageBitmap(objectDbModelClass.getOurImage());
    }

    @Override
    public int getItemCount() {
        return objectDbModelClassArrayList.size();
    }

    public static class DbViewHolder extends RecyclerView.ViewHolder{


        TextView imageDesTV; ImageView ourImageTV;

            public DbViewHolder(@NonNull View itemView) {
                super(itemView);
                imageDesTV=itemView.findViewById(R.id.sr_imagedesc);
                ourImageTV=itemView.findViewById(R.id.sr_image);
            }
        }
}

