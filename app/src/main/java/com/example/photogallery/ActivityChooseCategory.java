package com.example.photogallery;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.InputStream;

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

        //Images within a category
        ImageButton img1 = (ImageButton) findViewById(R.id.imageView01);
        ImageButton img2 = (ImageButton) findViewById(R.id.imageView02);
        ImageButton img3 = (ImageButton) findViewById(R.id.imageView03);
        ImageButton img4 = (ImageButton) findViewById(R.id.imageView04);


        assert photos != null;
        String[] urls = photos.activateImagesActivity();

        if (urls != null) {

            new DownloadImageTask(img1).execute(urls[0]);


        }

        Intent intent = new Intent(getApplicationContext(), ActivityDisplayCategory.class);

        ImageButton lions = (ImageButton) findViewById(R.id.categoryView01);
        ImageButton tigers = (ImageButton) findViewById(R.id.categoryView02);
        ImageButton bears = (ImageButton) findViewById(R.id.categoryView03);
        ImageButton jackalopes = (ImageButton) findViewById(R.id.categoryView04);


        photos.activateCategoryActivity("tigers");


        startActivity(intent);

    }

    private static class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;
        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap bmp = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                bmp = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return bmp;
        }
        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}

