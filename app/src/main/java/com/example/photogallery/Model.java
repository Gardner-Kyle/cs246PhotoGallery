package com.example.photogallery;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.io.IOException;
import java.io.InputStreamReader;

public class Model extends Thread {

    static ArrayList<Photo> photoArray;
    private static String category;

    public void getPhotoArray(String category) {
        Model.category = category;
        Model model = new Model();
        model.start();
    }

    private static void setPhotoArray(ArrayList<Photo> imageArray) {
        Model.photoArray = imageArray;
    }

    public void run(){
        System.out.println("MyThread running");
        HttpURLConnection request;
        try {
            URL url = new URL("https://pixabay.com/api/?key=15256236-228f0977aeaa8566bd1c561bb&q=" + Model.category + "&image_type=photo");
            request = (HttpURLConnection)url.openConnection();
            request.setDoOutput(true);
            request.setRequestMethod("GET");
            request.connect();

            JsonParser jp = new JsonParser();
            JsonElement element = jp.parse(new InputStreamReader((InputStream)request.getContent()));
            JsonObject object = element.getAsJsonObject();
            JsonArray array = object.get("hits").getAsJsonArray();

            ArrayList<Photo> imageArray = new ArrayList<Photo>();
            for (JsonElement imageElement : array) {
                JsonObject imageObject = imageElement.getAsJsonObject();
                String imageUrl = imageObject.get("previewURL").getAsString();
                String imageCategory = Model.category;
                Photo photo = new Photo(imageUrl, imageCategory);
                imageArray.add(photo);
            }
            setPhotoArray(imageArray);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
