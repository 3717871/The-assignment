package nl.inholland.appliedmathematics.oop3.moviewatchlist.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class OMDBBasicTest {

    @Test
    void testRequestUnstructuredMovieInfo() {
        
        // This method makes a call to the omdb website and retrieves information from there in the form of a large String object.
        // For the test data I have decided to go with the movie name 'Blade Runner 2049'.

        // Arrange
        String test = "";

        try{ 

            URL movieUrl = new URI("http://www.omdbapi.com/?apikey=4e034029&" + "t=" + "Blade+Runner+2049").toURL();
            BufferedReader in = new BufferedReader(new InputStreamReader(movieUrl.openStream()));

            test = in.readLine();
            in.close();
            
            } catch (IOException e) {
                // Connection failed
            } catch (URISyntaxException e){
                // URL failed
        }
        
        // Act
        String methodResult = OMDBBasic.requestUnstructuredMovieInfo("Blade Runner 2049");

        // Assert
        assertEquals(test, methodResult);

    }


    @Test
    void testFindMovieInfo() {

        // Testing with the same Name.

        // Arrange
        List<String> testDataList = new ArrayList<>();
        testDataList.add("Blade Runner 2049");
        testDataList.add("2017");
        testDataList.add("Denis Villeneuve");
        testDataList.add("Action");

        String testDataString = "";

        try{ 

            URL movieUrl = new URI("http://www.omdbapi.com/?apikey=4e034029&" + "t=" + "Blade+Runner+2049").toURL();
            BufferedReader in = new BufferedReader(new InputStreamReader(movieUrl.openStream()));

            testDataString = in.readLine();
            in.close();
            
            } catch (IOException e) {
                // Connection failed
            } catch (URISyntaxException e){
                // URL failed
        }

        // Act
        List<String> methodResult = OMDBBasic.findMovieInfo(testDataString);

        // Assert
        assertEquals(testDataList, methodResult);

    }


    @Test
    void testGetMovieInfo() {

        // Now let us try testing it with an empty list.

        // Arrange
        List<String> test = new ArrayList<>();

        // Act
        List<String> methodResult = OMDBBasic.getMovieInfo("");

        // Assert
        assertEquals(test, methodResult);

    }
}
