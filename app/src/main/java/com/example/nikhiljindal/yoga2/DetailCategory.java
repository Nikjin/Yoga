package com.example.nikhiljindal.yoga2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailCategory extends AppCompatActivity {

    /*Integer[] imageIds={
            R.drawable.y1,
            R.drawable.y2,
            R.drawable.y3,
            R.drawable.y4,
            R.drawable.y5,
            R.drawable.y6,
            R.drawable.y7,
            R.drawable.y8,
            R.drawable.y9,
            R.drawable.y10,
            R.drawable.y11,
            R.drawable.y12,
            R.drawable.y13,
            R.drawable.y14,
            R.drawable.y15,
            R.drawable.y16,
            R.drawable.y17,
            R.drawable.y18,
            R.drawable.y19,
            R.drawable.y20,
    };*/
    final Context context = this;

    private ArrayList<class_category>catlst;

    @SuppressLint("SdCardPath")

    TextView textbenefits;
    TextView textprecaution;
    TextView textdescription;
    TextView textview;
    ImageView imageview;
    String asana_name;
     String description;
     String benefits;
     String precautions;
     String image;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dcategory);
        Intent i=getIntent();
        
        
            imageview = (ImageView) findViewById(R.id.imageview);
            image = i.getStringExtra("image");
            Log.d("image",image);
            int resID = getResources().getIdentifier("@drawable/" + image, "drawable", this.getPackageName());
            imageview.setImageResource(resID);



        textbenefits = (TextView)findViewById(R.id.textbenefits);
        benefits= i.getStringExtra("benefits");
        textbenefits.setText(benefits.toString());

        textdescription = (TextView) findViewById(R.id.textdesription);
        description= i.getStringExtra("description");
        textdescription.setText(description.toString());

        textprecaution = (TextView)findViewById(R.id.textprecaution);
        precautions= i.getStringExtra("precautions");
        textprecaution.setText(precautions.toString());

        textview = (TextView)findViewById(R.id.textview);
        asana_name= i.getStringExtra("asana_name");
        textview.setText(asana_name.toString());




    }
}
