package com.google.firebase.codelab.friendlychat;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by dumitru on 16. 12. 7.
 */

public class Translator {
    private static final String API_KEY = "trnsl.1.1.20161206T101500Z.87c571d9eb82149a.ffebb4020d352b0bb3d279ccc385efdd2c545e40";
    private static final String PREFIX = "https://translate.yandex.net/api/v1.5/tr.json/translate";
    static String translate(String from, String to, String text) throws IOException, ParseException {
        String URL = PREFIX + "?lang=" + from + "-" + to + "&key=" + API_KEY;
        String urlParameters = "text="+ URLEncoder.encode(text, "UTF-8");

        java.net.URL url = new URL(URL);
//        System.out.println(URL);
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setDoOutput(true);
        httpCon.setDoInput(true);
        httpCon.setRequestMethod("POST");

        OutputStreamWriter out = new OutputStreamWriter(
                httpCon.getOutputStream());
        out.write(urlParameters);
        out.flush();
        InputStreamReader in = new InputStreamReader((InputStream) httpCon.getContent());
        BufferedReader buff = new BufferedReader(in);
        String resp = "";
        String line;
        do {
            line = buff.readLine();
            if (line != null)
                resp += (line + "\n");
        } while (line != null);

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(resp);
        JSONObject jobj = (JSONObject) obj;
        return (String)((JSONArray) jobj.get("text")).get(0);
    }
}
