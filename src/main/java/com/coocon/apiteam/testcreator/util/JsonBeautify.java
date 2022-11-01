package com.coocon.apiteam.testcreator.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.json.JSONObject;

public class JsonBeautify {

    public static String getBeautifyJson(JSONObject jsonObject){
        return getBeautifyJson(jsonObject.toString());
    }

    public static String getBeautifyJson(String string){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement je = JsonParser.parseString(string);
        return gson.toJson(je);
    }

}
