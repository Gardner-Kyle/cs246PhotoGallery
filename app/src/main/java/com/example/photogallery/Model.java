package com.example.photogallery;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class Model {

    ArrayList<Object> imageArray;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public ArrayList<Object> getImageArray(String category) {

        String url = "https://pixabay.com/api/?key=15256236-228f0977aeaa8566bd1c561bb&q=" + category + "&image_type=photo";

        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);

            BufferedReader bufReader = new BufferedReader(new InputStreamReader(
                    response.getEntity().getContent()));

            StringBuilder builder = new StringBuilder();

            String line;

            while ((line = bufReader.readLine()) != null) {

                builder.append(line);
                builder.append(System.lineSeparator());
            }
            System.out.println(builder);

            // parse the info into the image array

        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageArray;
    }
}
