package com.example.photogallery;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import java.io.InputStream;


public class ActivityDisplayCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_category);

        /*// Retrieving photos object of class Presenter from previous Activity
        Intent i = getIntent();
        Presenter photos = (Presenter)i.getSerializableExtra("PresenterObj");*/


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
