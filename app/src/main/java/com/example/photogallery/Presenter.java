package com.example.photogallery;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import java.util.ArrayList;

import static android.app.PendingIntent.getActivity;


class Presenter extends Thread{
    private static final String KEY = "username";
    Model photos = new Model();

    /*Save the username to internal storage*/
    public void activateUserInfo(final String name, final Context context){

        Thread save = new Thread(new Runnable()
        {
            @Override
            public void run(){

                Log.d(name, "Name was received as: ");

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

    /*When the user selects a category, activate it in Display Category activity*/

    void activateCategoryActivity(String category){

        photos.getPhotoArray(category);
    }


    String[] activateImagesActivity(){

         ArrayList<Photo> p = photos.photoArray;
         String[] s = new String[4];
         for(int i=0; i<4;i++){
             s[i] = toString().valueOf(p.get(i));
         }
         return s;
    }

}


