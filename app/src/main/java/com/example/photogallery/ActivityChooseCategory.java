package com.example.photogallery;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class ActivityChooseCategory extends AppCompatActivity {

    Presenter photos = new Presenter();

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
        ArrayList<Photo> photoCategory = new ArrayList<>();

        Intent intent = new Intent(getApplicationContext(), ActivityDisplayCategory.class);

        ImageButton lions = (ImageButton) findViewById(R.id.categoryView01);
        ImageButton tigers = (ImageButton) findViewById(R.id.categoryView02);
        ImageButton bears = (ImageButton) findViewById(R.id.categoryView03);
        ImageButton jackalopes = (ImageButton) findViewById(R.id.categoryView04);

        startActivity(intent);
    }
}

