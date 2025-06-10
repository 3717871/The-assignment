package nl.inholland.appliedmathematics.oop3.moviewatchlist.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.junit.jupiter.api.Test;

public class TMDBSimilarTest {

    @Test
    void testRequestUnstructuredMovieID() {

        // For this class the tests will be conducted with movie name 'Star Wars'
        // Arrange
        String TMDB_APITOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4MDMxMzVlYWM0YWYxZmZjMzMwNGJiYmE2MjIyMTUwZCIsIm5iZiI6MTc0NjA4OTc4NC4yODMsInN1YiI6IjY4MTMzNzM4YjYzNzA2NTVmYjkwZmYxZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.R_OxsImltSnT9Tk9IJuwm53fwGpBZQ6eMNe9ldM8FfA";
        String test = "";
        
        try{

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.themoviedb.org/3/search/movie?query=" + "Star%20Wars" + "&include_adult=false&language=en-US&page=1"))
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

    }

    @Test
    void testFindSimilarMovies() {

    }

    @Test
    void testGetSimilarMovies() {

    }


    @Test
    void testRequestUnstructuredSimilarMovies() {

    }
}
