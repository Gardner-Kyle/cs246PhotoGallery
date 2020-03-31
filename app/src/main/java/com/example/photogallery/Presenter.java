package com.example.photogallery;

import android.content.Context;
import android.content.SharedPreferences;

import static android.app.PendingIntent.getActivity;


class Presenter extends Thread{
    private static final String KEY = "username";
    private String category = "";
    Model photos = new Model();
    private String[] img = new String[4];

    /*Save the username to internal storage*/
    public void activateUserInfo(final String name, final Context context){

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

    /*When the user selects a category, activate it in Display Category activity*/

    void activateCategoryActivity(String category){
        this.category = category;
    }

    String[] getImagesFromModel() {

        photos.getPhotoArray(this.category);

        for(int i=0; i<4;i++){
            String drawableRes = Model.photoArray.get(i).url;
            this.img[i] = drawableRes;

        }

        return this.img;
    }

    /*
    Bitmap[] activateImagesActivity(){


        Bitmap[] bitMappedPhotos = new Bitmap[4];
        for(int strSrc = 0; strSrc<4 ; strSrc++) {
            try {
                byte[] encodeByte = Base64.decode(this.img[strSrc], Base64.DEFAULT);
                Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);

                bitMappedPhotos[strSrc] = bitmap;
            } catch (Exception e) {
                e.getMessage();
                return null;
            }
        }

        return bitMappedPhotos;
    }*/

}


