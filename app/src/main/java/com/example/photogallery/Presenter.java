package com.example.photogallery;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.View;

import java.util.ArrayList;

import static android.app.PendingIntent.getActivity;


class Presenter {
    private static final String KEY = "username";


    /*Save the username to internal storage
    * Get Image Category and send it to Choose category activity
    */
    public static class GetImagesFromModel extends AsyncTask<String,Void, ArrayList<Photo>>{
        private static final String FILE = "userInfo";
        Model obj;
        private Context context;

        //Context will be specified at instantiation : Can only be done in UI thread.
        GetImagesFromModel(Context context) { this.context = context; }

        @Override
        protected ArrayList<Photo> doInBackground(String... params) {
            //If we're dealing with the main activity we can save the user name
            if ( this.context instanceof MainActivity ) {
                SharedPreferences s = context.getSharedPreferences(FILE, Context.MODE_PRIVATE);

                SharedPreferences.Editor edit = s.edit();
                edit.putString(KEY, params[0]);
                edit.apply();

            }

            else if( this.context instanceof ActivityChooseCategory) {

                //param[0] in this case will be the string value of the category
                //Entered when the user selects a category
                return activateCategoryActivity(obj, params[0]);
            }
            return Model.photoArray;
        }

        @Override
        protected void onPostExecute(ArrayList<Photo> photos) {
            setImage(photos);
        }

        private void setImage(View a, View b, View c, View d)
        {

            if(obj.photoArray.get(0) == null)
            {
                System.out.println("NULL drawable");
            }
            imageButton.setImageResource(obj.photoArray.get(0));
            ImageView2.setImageResource(obj.photoArray.get(1));
            ImageView3.setImageResource(obj.photoArray.get(2));
            ImageView4.setImageResource(obj.photoArray.get(3));
        }
    }



    protected static ArrayList<Photo> activateCategoryActivity(Model photos, String category){

        //Get images in the specified category as an array and display them in
        //ActivityDisplayCategory. Activated in ActivityChooseCategory

        photos.getPhotoArray(category);

        //An array of images from the selected category returned
        return photos.photoArray;
    }

    protected ArrayList<Model> activateUserInfoActivity(String a, String b, String c, String d){
        return null;
    }

    protected ArrayList<Model> activateSingleImageActivity(String a, String b, String c, String d){
        return null;
    }
}


