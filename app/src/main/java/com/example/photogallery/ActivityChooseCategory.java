package com.example.photogallery;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

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

        ImageView lions = (ImageView) findViewById(R.id.categoryView01);
        ImageView tigers = (ImageView) findViewById(R.id.categoryView02);
        ImageView bears = (ImageView) findViewById(R.id.categoryView03);
        ImageView jackalopes = (ImageView) findViewById(R.id.categoryView04);

        Presenter.GetImagesFromModel photos = new Presenter.GetImagesFromModel(this);


        if(view == lions) {
            photos.doInBackground("Lions");
        }
        else if(view == bears) {
            photos.doInBackground("Bears");
        }
        else if(view == tigers) {
            photos.doInBackground("Tigers");
        }
        else if(view == jackalopes) {
            photos.doInBackground("Jackalopes");
        }
        Intent intent = new Intent(getApplicationContext(), ActivityDisplayCategory.class);

        startActivity(intent);
    }
}
