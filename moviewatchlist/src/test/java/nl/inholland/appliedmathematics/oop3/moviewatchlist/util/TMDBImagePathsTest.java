package nl.inholland.appliedmathematics.oop3.moviewatchlist.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

public class TMDBImagePathsTest {

        @Test
    void testRequestUnstructutredImageFilePaths() {

        // Assert
        String TMDB_APITOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4MDMxMzVlYWM0YWYxZmZjMzMwNGJiYmE2MjIyMTUwZCIsIm5iZiI6MTc0NjA4OTc4NC4yODMsInN1YiI6IjY4MTMzNzM4YjYzNzA2NTVmYjkwZmYxZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.R_OxsImltSnT9Tk9IJuwm53fwGpBZQ6eMNe9ldM8FfA";
        String testString = "";

        try{

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.themoviedb.org/3/movie/" + testString + "/images"))
                .header("accept", "application/json")
                .header("Authorization", "Bearer " + TMDB_APITOKEN)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            testString = response.body();
            
         
        } catch(InterruptedException e){
            //Thread interrupted
        } catch(IOException e){
            //Failed Connection
        }

        // Act
        String emtpyMethodResult = TMDBImagePaths.requestUnstructutredImageFilePaths("");

        // Assert
        assertEquals(testString, emtpyMethodResult);
    }

    
    @Test
    void testFindImageFilePaths() {

        // Assert
        String TMDB_APITOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4MDMxMzVlYWM0YWYxZmZjMzMwNGJiYmE2MjIyMTUwZCIsIm5iZiI6MTc0NjA4OTc4NC4yODMsInN1YiI6IjY4MTMzNzM4YjYzNzA2NTVmYjkwZmYxZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.R_OxsImltSnT9Tk9IJuwm53fwGpBZQ6eMNe9ldM8FfA";
        String testString = "11";
        List<String> testEmptyList = new ArrayList<>();

        try{

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.themoviedb.org/3/movie/" + testString + "/images"))
                .header("accept", "application/json")
                .header("Authorization", "Bearer " + TMDB_APITOKEN)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            testString = response.body();
            
         
        } catch(InterruptedException e){
            //Thread interrupted
        } catch(IOException e){
            //Failed Connection
        }

        List<String> filePaths = new ArrayList<>();

        Pattern pattern = Pattern.compile("\"file_path\":\"/(\\w+|\\.)+");
        Matcher matcher = pattern.matcher(testString);

        int count = 0;

        while (matcher.find() && count < 3){
            filePaths.add(matcher.group().substring(14).trim());
            count++;
        }

        // Act
        List<String> methodResult = TMDBImagePaths.findImageFilePaths(testString);
        List<String> emptyMethodResult = TMDBImagePaths.findImageFilePaths("");

        // Assert
        assertEquals(testEmptyList, emptyMethodResult);
        assertEquals(methodResult, filePaths);
        

    }


    @Test
    void testGetImageFilePaths() {

        // Assert
        List<String> empty = new ArrayList<>();

        // Act
        List<String> methodResult = TMDBImagePaths.getImageFilePaths("");

        // Assert
        assertEquals(empty, methodResult);

    }
}
