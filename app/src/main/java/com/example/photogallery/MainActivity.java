package com.example.photogallery;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    public static final String NAME = "com.example.imageviewer.NAME";

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
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

        intent.putExtra(NAME, name);
        startActivity(intent);
    }
}
