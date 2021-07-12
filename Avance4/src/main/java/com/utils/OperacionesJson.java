package com.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;

public class OperacionesJson {

    public static final Gson gson = new Gson();

    public static String obtenerJson(BufferedReader br) {
        try {
            StringBuffer sb = new StringBuffer();
            String str = null;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            return sb.toString();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static JsonObject stringToJson(String json) {
        JsonObject objetoJson = gson.fromJson(json, JsonObject.class);
        return objetoJson;
    }

}
