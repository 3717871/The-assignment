package nl.inholland.appliedmathematics.oop3.moviewatchlist.model;

// My DTO class which I see as what the User fills in to correctly Post a movie.

public record MovieDTO(String movieName, boolean watched, int rating, String destinationFolder) {

        @Override
        public String toString(){
            return String.format("{ \"movieName\": %s, \"watched\": %b, \"rating\": %d, \"destinationFolder\": %s }", 
            movieName, watched, rating, destinationFolder);
        }
}
