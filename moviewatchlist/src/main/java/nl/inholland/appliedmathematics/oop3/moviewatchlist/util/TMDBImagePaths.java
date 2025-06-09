package nl.inholland.appliedmathematics.oop3.moviewatchlist.util;

import lombok.Getter;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ToString
@EqualsAndHashCode

public class TMDBImagePaths {

    @Getter private static final String TMDB_APITOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4MDMxMzVlYWM0YWYxZmZjMzMwNGJiYmE2MjIyMTUwZCIsIm5iZiI6MTc0NjA4OTc4NC4yODMsInN1YiI6IjY4MTMzNzM4YjYzNzA2NTVmYjkwZmYxZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.R_OxsImltSnT9Tk9IJuwm53fwGpBZQ6eMNe9ldM8FfA";
    // private final String TMDB_apiKey = "803135eac4af1ffc3304bbba6222150d"; I do not use this variable, but I would not just delete it.

    public static String requestUnstructutredImageFilePaths(String movieID){

        String unstructuredFilePaths = "";

        try{

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.themoviedb.org/3/movie/" + movieID + "/images"))
                .header("accept", "application/json")
                .header("Authorization", "Bearer " + TMDB_APITOKEN)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            unstructuredFilePaths = response.body();
            
         
        } catch(InterruptedException e){
            //Thread interrupted
        } catch(IOException e){
            //Failed Connection
        }

        return unstructuredFilePaths;
    }


    public static List<String> findImageFilePaths(String responseBody){

        List<String> filePaths = new ArrayList<>();

        Pattern pattern = Pattern.compile("\"file_path\":\"/(\\w+|\\.)+");
        Matcher matcher = pattern.matcher(responseBody);

        int count = 0;

        while (matcher.find() && count < 3){
            filePaths.add(matcher.group().substring(14).trim());
            count++;
        }

        return filePaths;
    }


    public static List<String> getImageFilePaths(String movieName){

        return findImageFilePaths(requestUnstructutredImageFilePaths(TMDBSimilar.findMovieID(TMDBSimilar.requestUnstructuredMovieID(movieName))));
    }
}
