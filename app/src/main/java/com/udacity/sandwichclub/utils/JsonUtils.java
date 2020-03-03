package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try{
            //Create JSON object
            JSONObject jsonObject = new JSONObject(json);
            //Get names
            JSONObject name = jsonObject.getJSONObject("name");
            //get mainName
            String mainName = name.getString("mainName");
            //get also known as
            JSONArray alsonKnoenAsArray = name.getJSONArray("alsoKnownAs");
            ArrayList<String> alsoKnownAs = new ArrayList<>();
            for(int i=0; i<alsonKnoenAsArray.length(); i++){
                alsoKnownAs.add(alsonKnoenAsArray.getString(i));
            }
            //get placeOfOrigin
            String placeOfOrigin = jsonObject.getString("placeOfOrigin");
            //getDescription
            String description = jsonObject.getString("description");
            //get Image
            String imgUrl = jsonObject.getString("image");
            //get Ingredients
            JSONArray ingredientsJSONArray = jsonObject.getJSONArray("ingredients");
            ArrayList<String> ingredients = new ArrayList<>();
            for (int i=0; i<ingredientsJSONArray.length(); i++){
                ingredients.add(ingredientsJSONArray.getString(i));
            }
            //Return Sandwich Object

            return new Sandwich(mainName,alsoKnownAs,placeOfOrigin,description,imgUrl,ingredients);
        }catch (JSONException e){
            e.printStackTrace();
        }
        return null;
    }
}
