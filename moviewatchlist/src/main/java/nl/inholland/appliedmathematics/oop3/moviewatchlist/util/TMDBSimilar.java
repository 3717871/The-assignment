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

public class TMDBSimilar {

    @Getter private static final String TMDB_APITOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4MDMxMzVlYWM0YWYxZmZjMzMwNGJiYmE2MjIyMTUwZCIsIm5iZiI6MTc0NjA4OTc4NC4yODMsInN1YiI6IjY4MTMzNzM4YjYzNzA2NTVmYjkwZmYxZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.R_OxsImltSnT9Tk9IJuwm53fwGpBZQ6eMNe9ldM8FfA";
    // private final String TMDB_apiKey = "803135eac4af1ffc3304bbba6222150d"; I do not use this variable, but I would not just delete it.

    public static String requestUnstructuredMovieID(String movieName){

        String searchMovieName = movieName.replaceAll("\\s+", "%20");
        String result = "";
        
        try{

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.themoviedb.org/3/search/movie?query=" + searchMovieName + "&include_adult=false&language=en-US&page=1"))
                .header("accept", "application/json")
                .header("Authorization", "Bearer " + TMDB_APITOKEN)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            result = response.body();

        } catch(InterruptedException e){
            //Thread interrupted
        } catch(IOException e){
            //Failed Connection
        }

        return result;
    }


    public static String findMovieID(String movieInfo){

        String result = "";

        Pattern pattern = Pattern.compile("\"id\":\\d+");
        Matcher matcher = pattern.matcher(movieInfo);

        if (matcher.find()){
            return matcher.group().substring(5);
        } else {
            System.out.println("No movie found.");
        }

        return result;
    }


    public static String requestUnstructuredSimilarMovies(String movieID){

        String result = "";

        try{

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.themoviedb.org/3/movie/" + movieID + "/similar?language=en-US&page=1"))
                .header("accept", "application/json")
                .header("Authorization", "Bearer " + TMDB_APITOKEN)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            result = response.body();

        } catch(InterruptedException e){
            //Thread interrupted
        } catch(IOException e){
            //Failed Connection
        }

        return result;
    }


    public static List<String> findSimilarMovies(String responseBody){

        Pattern pattern = Pattern.compile("\"original_title\"\\:\"(\\w+|\\s)+");
        Matcher matcher = pattern.matcher(responseBody);

        List<String> similarMovieList = new ArrayList<>();

        int count = 0;

        while (matcher.find() && count < 3){
            similarMovieList.add(matcher.group().substring(18).trim());
            count++;
        }

        return similarMovieList;
    }

    public static List<String> getSimilarMovies(String movieName){

        return findSimilarMovies(requestUnstructuredSimilarMovies(findMovieID(requestUnstructuredMovieID(movieName))));
    }

}
