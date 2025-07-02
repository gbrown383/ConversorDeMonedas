package com.conversor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class ApiService {
    private final String API_KEY = "0cde1ce2f410d91ba2e7a62b";
    private final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public JSONObject getRates(String baseCurrency) throws Exception {
        String urlStr = BASE_URL + API_KEY + "/latest/" + baseCurrency;
        URL url = new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            response.append(inputLine);
        in.close();

        return new JSONObject(response.toString());
    }
}
