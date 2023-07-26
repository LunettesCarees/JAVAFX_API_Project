package com.example.javaassignment2.Utilities;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class CountryCode {

    public static ArrayList<String> getCountryCodes(String filePath) {
        ArrayList<String> countryCodes = new ArrayList<>();

        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String countryCode = jsonObject.getString("Code");
                countryCodes.add(countryCode);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return countryCodes;

    }
}
