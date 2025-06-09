package nl.inholland.appliedmathematics.oop3.moviewatchlist.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode

public class OMDBBasic {

    // private final String omdbApiKey = "4e034029"; I do not use this variable, but I would not just delete it.
    @Getter private static final String OMDB_URL_REQUEST = "http://www.omdbapi.com/?apikey=4e034029&";

    public static String requestUnstructuredMovieInfo(String movieName){

        String searchName = movieName.replaceAll("\\s+", "+");
        String result = "";

        try{ 

            URL movieUrl = new URI(OMDB_URL_REQUEST + "t=" + searchName).toURL();
            BufferedReader in = new BufferedReader(new InputStreamReader(movieUrl.openStream()));

            result = in.readLine();
            in.close();
            
            } catch (IOException e) {
                // Connection failed
            } catch (URISyntaxException e){
                // URL failed
        }
        
        return result;
    }

    
    public static List<String> findMovieInfo(String movieInfo){

        Pattern patternTitle = Pattern.compile("\"Title\":\"(\\w+|\\s)+"); 
        Pattern patternYear = Pattern.compile("\"Year\":\"\\d+");
        Pattern patternDirector = Pattern.compile("\"Director\":\"(\\w+|\\s)+");
        Pattern patternGenre = Pattern.compile("\"Genre\":\"\\w+");

        Matcher matcherTitle = patternTitle.matcher(movieInfo);
        Matcher matcherYear = patternYear.matcher(movieInfo);
        Matcher matcherDirector = patternDirector.matcher(movieInfo);
        Matcher matcherGenre = patternGenre.matcher(movieInfo);

        List<String> movieInfoList = new ArrayList<>();

        if (matcherTitle.find()){

            matcherYear.find();
            matcherDirector.find();
            matcherGenre.find();

            movieInfoList.add(matcherTitle.group().substring(9)); // Hard coded values, so a bit sloppy perhaps.
            movieInfoList.add(matcherYear.group().substring(8)); // But the positioning is always the same.
            movieInfoList.add(matcherDirector.group().substring(12));
            movieInfoList.add(matcherGenre.group().substring(9));
            
        } else {

            System.out.println("No movie found.");

        }

        return movieInfoList;
    }

    public static List<String> getMovieInfo(String movieName){
        return findMovieInfo(requestUnstructuredMovieInfo(movieName));
    }

}
