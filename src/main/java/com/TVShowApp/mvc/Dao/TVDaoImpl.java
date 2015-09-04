package com.TVShowApp.mvc.Dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.TVShowApp.mvc.Models.Show;
import com.google.gson.Gson;

public class TVDaoImpl {

//    String website = "http://api.tvmaze.com";

    Gson gson = new Gson();

    Show show;

    public void getShows() throws IOException {

//        URL url = new URL(website);

//        URLConnection con = url.openConnection();
//        InputStream is = con.getInputStream();
//        BufferedReader br = new BufferedReader(is);

//        String line = "{'id': 1, 'url': 'http://www.tvmaze.com/shows/1/under-the-dome', 'name': 'Under the Dome', 'summary': 'Test Description'}";

//        show = new Show(gson.fromJson(line, Show.class));



    }

}
