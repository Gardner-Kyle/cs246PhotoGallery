package com.example.photogallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public static final String NAME = "com.example.imageviewer.NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the 'Continue' button */
    public void continueToCategoryView(View view) {


        Intent intent     = new Intent(this, ActivityChooseCategory.class);
        EditText editText = (EditText) findViewById(R.id.editName);
        String name       = editText.getText().toString();

        //Instantiate Presenter and carry out name saving.
        Presenter saver = new Presenter();
        saver.activateUserInfo(editText.getText().toString(), this);

        intent.putExtra(NAME, name);
        startActivity(intent);
    }
}
