package com.example.photogallery;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ActivityChooseCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_category);

    }

    /** Called when the user taps the 'Home' button */
    public void returnHome(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);


        startActivity(intent);
    }

    /** Called when the user taps one of the 'Photo' button */
    public void viewCategory(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityDisplayCategory.class);


        startActivity(intent);

    }

}

