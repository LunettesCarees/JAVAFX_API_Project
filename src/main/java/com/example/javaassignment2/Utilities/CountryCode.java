package com.example.javaassignment2.Utilities;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class CountryCode {

    // This method is used to get the country codes from the json file
    public static ArrayList<String> getCountryCodes(String filePath) {
        ArrayList<String> countryCodes = new ArrayList<>();

        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String countryCode = jsonObject.getString("Code");
                String countryName = jsonObject.getString("Name");
                countryCodes.add(countryCode + " - " + countryName);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return countryCodes;

    }
}
