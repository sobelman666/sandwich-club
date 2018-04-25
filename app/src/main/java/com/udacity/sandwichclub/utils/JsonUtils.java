package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich parsedSandwich = null;
        try {
            // parse the string into a JSONObject
            JSONObject sandwichJson = new JSONObject(json);

            // the "name" field contains another JSON object
            JSONObject nameObject = sandwichJson.getJSONObject("name");

            // the "name" object contains the "mainName" and "alsoKnownAs" fields
            String mainName = nameObject.getString("mainName");
            // "alsoKnownAs" is a JSON array
            JSONArray alsoKnownAsArray = nameObject.getJSONArray("alsoKnownAs");
            // convert the "alsoKnownAs" JSON array to a List<String>
            List<String> alsoKnownAs = new ArrayList<>();
            for (int i = 0; i < alsoKnownAsArray.length(); i++) {
                alsoKnownAs.add(alsoKnownAsArray.getString(i));
            }

            String placeOfOrigin = sandwichJson.getString("placeOfOrigin");
            String description = sandwichJson.getString("description");
            String imageUrl = sandwichJson.getString("image");

            // "ingredients" is also a JSON array
            JSONArray ingredientsArray = sandwichJson.getJSONArray("ingredients");
            // convert the "ingredients" array to a List<String>
            List<String> ingredients = new ArrayList<>();
            for (int i = 0; i < ingredientsArray.length(); i++) {
                ingredients.add(ingredientsArray.getString(i));
            }

            // create a model object based on the parsed data
            parsedSandwich =
                    new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, imageUrl,
                            ingredients);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return parsedSandwich;
    }
}
