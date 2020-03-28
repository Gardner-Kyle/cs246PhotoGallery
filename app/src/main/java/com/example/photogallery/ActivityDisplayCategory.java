package com.example.photogallery;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ActivityDisplayCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_category);




/*
        image1.setImageResource(R.drawable.lion);//set the source in java class
        image2.setImageResource(R.drawable.lion);//set the source in java class
        image3.setImageResource(R.drawable.lion);//set the source in java class
        image4.setImageResource(R.drawable.lion);//set the source in java class*/

    }

    /** Called when the user taps the 'Home' button */
    public void returnHome(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);

        startActivity(intent);
    }

    /** Called when the user taps the 'Home' button */
    public void viewImage(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityViewImage.class);

        startActivity(intent);
    }
}
