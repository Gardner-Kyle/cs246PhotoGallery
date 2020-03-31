package com.example.photogallery;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.squareup.picasso.Picasso;

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
        Presenter presenter = new Presenter();

        Intent intent = new Intent(getApplicationContext(), ActivityDisplayCategory.class);

        ImageButton lions = (ImageButton) findViewById(R.id.categoryView01);
        ImageButton tigers = (ImageButton) findViewById(R.id.categoryView02);
        ImageButton bears = (ImageButton) findViewById(R.id.categoryView03);
        ImageButton jackalopes = (ImageButton) findViewById(R.id.categoryView04);

        if(view == lions){
            presenter.activateCategoryActivity("Lions");
        }
        if(view == tigers){
            presenter.activateCategoryActivity("Tigers");
        }
        if(view == bears){
            presenter.activateCategoryActivity("Bears");
        }
        if(view == jackalopes){
            presenter.activateCategoryActivity("Jackalopes");
        }

        ChangeImagesrc src =new ChangeImagesrc();
        src.doInBackground();

        startActivity(intent);
    }

    class ChangeImagesrc extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {

            //Images within a category
            ImageButton img1 = (ImageButton) findViewById(R.id.imageView01);
            ImageButton img2 = (ImageButton) findViewById(R.id.imageView02);
            ImageButton img3 = (ImageButton) findViewById(R.id.imageView03);
            ImageButton img4 = (ImageButton) findViewById(R.id.imageView04);

            String[] path = photos.getImagesFromModel();

            Picasso.with(getApplicationContext()).load(path[0]).into(img1);
            Picasso.with(getApplicationContext()).load(path[1]).into(img2);
            Picasso.with(getApplicationContext()).load(path[2]).into(img3);
            Picasso.with(getApplicationContext()).load(path[3]).into(img4);

            return null;
        }
    }
}

