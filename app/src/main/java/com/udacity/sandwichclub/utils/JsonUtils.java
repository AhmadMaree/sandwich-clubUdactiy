package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    private final static String TAG = "Utilts_Json";


    public static Sandwich parseSandwichJson(String json) {

        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(json);
            JSONObject name = jsonObject.getJSONObject("name");
            String main_name = name.getString("mainName");
            String sandwish_image = jsonObject.getString("image");
            String description = jsonObject.getString("description");
            JSONArray jsonArray = name.getJSONArray("alsoKnownAs");
            ArrayList<String> alsoKnowaS = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                alsoKnowaS.add(jsonArray.getString(i));
            }
            JSONArray jsonArray_ingredients = jsonObject.getJSONArray("ingredients");
            ArrayList<String> ingredients = new ArrayList<>();
            for (int i = 0; i < jsonArray_ingredients.length(); i++) {
                ingredients.add(jsonArray_ingredients.getString(i));
            }
            String place_of_origin = jsonObject.getString("placeOfOrigin");
            return new Sandwich(main_name, alsoKnowaS, place_of_origin, description, sandwish_image, ingredients);


        } catch (JSONException e1) {

            Log.e(TAG, e1.getLocalizedMessage());
            e1.printStackTrace();
            return null;
        }


    }
}

