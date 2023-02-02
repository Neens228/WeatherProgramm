package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


/**/
public class Connection {
    static ArrayList<String> Moscow = new ArrayList<>();
    String name = null;
    StringBuffer response = new StringBuffer();
    String readLine = null;

    public Connection (String name) throws IOException {
        this.name = name;
        URL url = new URL("http://api.weatherapi.com/v1/current.json?key=c786406a88464571810204524232301&q=" + name + "&aqi=no");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while (( readLine = in .readLine()) != null) {
                response.append(readLine);
            }
            in .close();

        } else {
            System.out.println("GET NOT WORKED");
        }
    }


    protected String getCityNameApi() {
        int findNameOfCity = response.indexOf("name");
        int findStartCityName = response.indexOf(":",findNameOfCity)+2;
        return response.substring(findStartCityName,response.indexOf("\"",findStartCityName));
    }

    protected String getTemp_C_Api() {
        int findNameOfCity = response.indexOf("temp_c");
        int findStartCityName = response.indexOf(":",findNameOfCity)+1;
        double round = Math.round(Double.parseDouble(response.substring(findStartCityName,response.indexOf(",",findStartCityName))));
        return String.valueOf(response.substring(findStartCityName,response.indexOf(",",findStartCityName)));
    }


    public String getHumidityApi() {
        int findNameOfCity = response.indexOf("humidity");
        int findStartCityName = response.indexOf(":",findNameOfCity)+1;
        return response.substring(findStartCityName,response.indexOf(",",findStartCityName));
    }

    protected String getFeelsLikeC(){
        int findNameOfCity = response.indexOf("feelslike_c");
        int findStartCityName = response.indexOf(":",findNameOfCity)+1;
        double finalFL = Math.round(Double.parseDouble(response.substring(findStartCityName,response.indexOf(",",findStartCityName))));
        return String.valueOf(finalFL);
    }

    protected String getWindMph(){
        int findNameOfCity = response.indexOf("wind_mph");
        int findStartCityName = response.indexOf(":",findNameOfCity)+1;
        return response.substring(findStartCityName,response.indexOf(",",findStartCityName));
    }


    protected String getText() {
        int findNameOfCity = response.indexOf("text");
        int findStartCityName = response.indexOf(":",findNameOfCity)+2;
        return response.substring(findStartCityName,response.indexOf("\"",findStartCityName));
    }

    protected String getLocalTime() {
        int findNameOfCity1 = response.indexOf("localtime");
        int findNameOfCity = response.indexOf("localtime",findNameOfCity1+1);
        int findStartCityName = response.indexOf(":",findNameOfCity)+2;
        response.substring(findStartCityName,response.indexOf("\"",findStartCityName)-1);
        return "Weather at " + response.substring(findStartCityName+5,response.indexOf("\"",findStartCityName));
    }
}
