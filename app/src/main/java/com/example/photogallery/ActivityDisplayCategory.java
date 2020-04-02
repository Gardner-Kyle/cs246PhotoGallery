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

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;


public class ActivityDisplayCategory extends AppCompatActivity {

    private ImageButton img1,img2,img3,img4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_category);

        /*// Retrieving photos object of class Presenter from previous Activity
        Intent i = getIntent();
        String[] photos = (String[])i.getSerializableExtra("PresenterObj");*/


        img1 = (ImageButton) findViewById(R.id.imageView01);
        img2 = (ImageButton) findViewById(R.id.imageView02);
        img3 = (ImageButton) findViewById(R.id.imageView03);
        img4 = (ImageButton) findViewById(R.id.imageView04);
        ImageButton[] img = {img1,img2,img3,img4};

        Presenter photos = new Presenter();
        photos.activateCategoryActivity("lions");
        String[] urls = photos.activateImagesActivity();


        URL url = null;
        try {
            url = new URL(urls[0]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        new LoadImageFromWebOperations(img).execute(url);
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

    static class LoadImageFromWebOperations extends AsyncTask<URL, Void, Bitmap>{
        Bitmap bmp = null;
        ImageButton[] view;
        LoadImageFromWebOperations(ImageButton[] v){this.view = v;}

        @Override
        protected Bitmap doInBackground(URL... urls) {
            try {
                bmp = BitmapFactory.decodeStream(urls[0].openConnection().getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bmp;
        }

        @Override
        protected void onPostExecute(Bitmap result){
            for(int x=0; x<4;x++) {
                this.view[x].setImageBitmap(bmp);
            }
        }
    }

}
