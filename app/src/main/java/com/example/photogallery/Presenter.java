package com.example.photogallery;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import java.util.ArrayList;

import static android.app.PendingIntent.getActivity;


class Presenter {
    private static final String KEY = "username";
    private static final String FILE = "userInfo";

    /*Save the username to internal storage
    * Get Image Category and send it to Choose category activity
    */
    public static class mainTask extends AsyncTask<String,Integer, Model>{
        private Context context;

        //Context will be specified at instantiation : Can only be done in UI thread.
        mainTask(Context context) { this.context = context; }

        @Override
        protected Model doInBackground(String... params) {

            //First parameter is the username denoted with params[0]
            SharedPreferences s = context.getSharedPreferences(FILE, Context.MODE_PRIVATE);

            SharedPreferences.Editor edit = s.edit();
            edit.putString(KEY,params[0]);
            edit.apply();

            return new Model();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Model model) {
            super.onPostExecute(model);
        }
    }

}


