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

public class TMDBSimilarTest {

    @Test
    void testRequestUnstructuredMovieID() {

        // For this class the tests will be conducted with movie name 'Star Wars'
        // Arrange
        String TMDB_APITOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4MDMxMzVlYWM0YWYxZmZjMzMwNGJiYmE2MjIyMTUwZCIsIm5iZiI6MTc0NjA4OTc4NC4yODMsInN1YiI6IjY4MTMzNzM4YjYzNzA2NTVmYjkwZmYxZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.R_OxsImltSnT9Tk9IJuwm53fwGpBZQ6eMNe9ldM8FfA";
        String test = "";

        String testName = "Star%20Wars";
        
        try{

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.themoviedb.org/3/search/movie?query=" + testName + "&include_adult=false&language=en-US&page=1"))
                .header("accept", "application/json")
                .header("Authorization", "Bearer " + TMDB_APITOKEN)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            test = response.body();

        } catch(InterruptedException e){
            //Thread interrupted
        } catch(IOException e){
            //Failed Connection
        }
        
        // Act
        String methodResult = TMDBSimilar.requestUnstructuredMovieID("Star Wars");

        // Assert
        assertEquals(test, methodResult);
        
    }


    @Test
    void testFindMovieID() {

        // Arrange
        String TMDB_APITOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4MDMxMzVlYWM0YWYxZmZjMzMwNGJiYmE2MjIyMTUwZCIsIm5iZiI6MTc0NjA4OTc4NC4yODMsInN1YiI6IjY4MTMzNzM4YjYzNzA2NTVmYjkwZmYxZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.R_OxsImltSnT9Tk9IJuwm53fwGpBZQ6eMNe9ldM8FfA";
        String testString = "";
        
        try{

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.themoviedb.org/3/search/movie?query=" + "Star%20Wars" + "&include_adult=false&language=en-US&page=1"))
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

        Pattern pattern = Pattern.compile("\"id\":\\d+");
        Matcher matcher = pattern.matcher(testString);

        String testBody = "";

        if (matcher.find()){
            testBody =  matcher.group().substring(5);
        } else {
            System.out.println("No movie found.");
        }

        // Act
        String methodResult = TMDBSimilar.findMovieID(testString);
        String emptyMethodResult = TMDBSimilar.findMovieID("methodResult");

        // Assert
        assertEquals(testBody, methodResult);
        assertEquals("", emptyMethodResult);

    }


        @Test
    void testRequestUnstructuredSimilarMovies() {

        // Assert
        String TMDB_APITOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4MDMxMzVlYWM0YWYxZmZjMzMwNGJiYmE2MjIyMTUwZCIsIm5iZiI6MTc0NjA4OTc4NC4yODMsInN1YiI6IjY4MTMzNzM4YjYzNzA2NTVmYjkwZmYxZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.R_OxsImltSnT9Tk9IJuwm53fwGpBZQ6eMNe9ldM8FfA";
        String testId = TMDBSimilar.findMovieID(TMDBSimilar.requestUnstructuredMovieID("StarWars"));

        String testString = "";

        try{

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.themoviedb.org/3/movie/" + testId + "/similar?language=en-US&page=1"))
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
        String methodResult = TMDBSimilar.requestUnstructuredSimilarMovies(testId);

        // Assert
        assertEquals(testString, methodResult);

    }


    @Test
    void testFindSimilarMovies() {

        // Assert
        List<String> emptyTestBody = new ArrayList<>();;

        // Act 
        List<String> methodResult = TMDBSimilar.findSimilarMovies("");

        // Assert
        assertEquals(emptyTestBody, methodResult);


    }

    @Test
    void testGetSimilarMovies() {

        // Assert
        List<String> emptyTestList = new ArrayList<>();
        emptyTestList.add("The Fountain");
        emptyTestList.add("Superman Returns");
        emptyTestList.add("Thelma & Louise");

        // Act
        List<String> methodResult = TMDBSimilar.getSimilarMovies("Star Wars");

        // Assert
        assertEquals(emptyTestList, methodResult);

    }
}
