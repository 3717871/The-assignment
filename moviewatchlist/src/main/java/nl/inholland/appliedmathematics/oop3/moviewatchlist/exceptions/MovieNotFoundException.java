package nl.inholland.appliedmathematics.oop3.moviewatchlist.exceptions;

public class MovieNotFoundException extends RuntimeException{

    public MovieNotFoundException(String message) {
        super(message);
        }

}
