package com.valoit.volleyrecycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ImageSlider imageSlider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        ImageSlider imageSlider;
        TextView hospital,launch;


        imageSlider =findViewById(R.id.image_slider);
        hospital  =findViewById(R.id.hospital);
        launch=findViewById(R.id.launch);

        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel("https://img.freepik.com/free-vector/woman-office-suit-points-demo-board-with-graphs_71593-857.jpg?w=2000", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://img.freepik.com/free-vector/woman-office-suit-points-demo-board-with-graphs_71593-857.jpg?w=2000",ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://img.freepik.com/free-vector/woman-office-suit-points-demo-board-with-graphs_71593-857.jpg?w=2000",ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://img.freepik.com/free-vector/woman-office-suit-points-demo-board-with-graphs_71593-857.jpg?w=2000",ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://img.freepik.com/free-vector/woman-office-suit-points-demo-board-with-graphs_71593-857.jpg?w=2000",ScaleTypes.CENTER_CROP));
        imageSlider.setImageList(imageList);

        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,HospitalActivity.class);
                startActivity(intent);
            }
        });

        launch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,LaunchActivity.class);
                startActivity(intent);
            }
        });














    }
}