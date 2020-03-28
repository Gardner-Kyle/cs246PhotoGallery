package com.example.photogallery;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import static android.app.PendingIntent.getActivity;


class Presenter {
    private Context context;
    private static final String KEY = "username";

    /*Save the username to internal storage*/
    public void activateUserInfo(final String name){

        Thread save = new Thread(new Runnable()
        {
            @Override
            public void run(){

                //Context will be specified at instantiation : Can only be done in UI thread.
                String FILE = "userInfo";
                SharedPreferences s = context.getSharedPreferences(FILE, Context.MODE_PRIVATE);

                SharedPreferences.Editor edit = s.edit();
                edit.putString(KEY, name);
                edit.apply();
            }
        }, "SavingUserName");
        save.start();

    }

    public void activateCategoryActivity(){
        ImageView lions = (ImageView) findViewById(R.id.categoryView01);
        ImageView tigers = (ImageView) findViewById(R.id.categoryView02);
        ImageView bears = (ImageView) findViewById(R.id.categoryView03);
        ImageView jackalopes = (ImageView) findViewById(R.id.categoryView04);



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
    }

}


