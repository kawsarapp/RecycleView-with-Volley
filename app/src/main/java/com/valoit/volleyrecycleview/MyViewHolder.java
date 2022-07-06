package com.valoit.volleyrecycleview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {


    TextView headText, descText;
    ImageView imageView;




    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView=(ImageView) itemView.findViewById(R.id.imageId);
        headText=(TextView) itemView.findViewById(R.id.headId);
        descText=(TextView) itemView.findViewById(R.id.descId);



    }





}
