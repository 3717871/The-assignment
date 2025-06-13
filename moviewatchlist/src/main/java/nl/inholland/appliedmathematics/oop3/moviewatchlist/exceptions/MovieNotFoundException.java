package nl.inholland.appliedmathematics.oop3.moviewatchlist.exceptions;

// Exception class which I made in case a Movie could not be found in the database when updating it.

public class MovieNotFoundException extends RuntimeException{

    public MovieNotFoundException(String message) {
        super(message);
        }

}
