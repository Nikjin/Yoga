package com.example.nikhiljindal.yoga2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button but;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but= findViewById(R.id.but);

    }

    public void onClick(View view) {
        Intent i = new Intent(getApplicationContext(),CategoryActivity.class);
        startActivity(i);

    }
}
