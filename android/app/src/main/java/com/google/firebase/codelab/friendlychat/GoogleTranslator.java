package com.google.firebase.codelab.friendlychat;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by dumitru on 16. 12. 7.
 */

public class GoogleTranslator {
    private static final String API_KEY = "AIzaSyBMLqNChrhtQaEu3XmZTCf4RyA6GLH8mx0";
    private static final String PREFIX = "https://www.googleapis.com/language/translate/v2";

    static String translate(String from, String to, String text) throws IOException, ParseException {
        text = URLEncoder.encode(text, "UTF-8");
        String URL = PREFIX + "?q=" + text + "&target=" + to + "&source=" + from + "&key=" + API_KEY;
        //System.out.println(URL);
        java.net.URL url = new URL(URL);
        System.out.println(URL);
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        //httpCon.setDoOutput(true);
        httpCon.setDoInput(true);
        httpCon.setRequestMethod("GET");
        System.out.println(httpCon.getResponseCode());
        InputStreamReader in = new InputStreamReader((InputStream) httpCon.getContent());
        BufferedReader buff = new BufferedReader(in);
        String resp = "";
        String line;
        do {
            line = buff.readLine();
            if (line != null)
                resp += (line + "\n");
        } while (line != null);
//        System.out.println(resp);

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(resp);
        JSONObject jobj = (JSONObject) obj;
        String result = (String)((JSONObject)((JSONArray)((JSONObject)jobj.get("data")).get("translations")).get(0)).get("translatedText");
//        System.out.println(jobj.get("code"));
//        System.out.println(jobj.get("lang"));
//        System.out.println(jobj.get("text"));

        return result;
    }
}
