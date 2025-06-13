package nl.inholland.appliedmathematics.oop3.moviewatchlist.exceptions;

// Exception class for when someone filled in a rating which to me seems illegal.

public class RatingOutOfBoundsException extends RuntimeException{

    public RatingOutOfBoundsException(){
        super("The rating that you gave is below zero or higher than five which is not allowed. Please provide a number that is or is between zero and five.");
    }

}
