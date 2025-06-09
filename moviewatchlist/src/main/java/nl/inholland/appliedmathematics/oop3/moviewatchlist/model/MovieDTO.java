package nl.inholland.appliedmathematics.oop3.moviewatchlist.model;

public record MovieDTO(String movieName, boolean watched, int rating, String destinationFolder) {

        @Override
        public String toString(){
            return String.format("{ \"movieName\": %s, \"watched\": %b, \"rating\": %d, \"destinationFolder\": %s }", 
            movieName, watched, rating, destinationFolder);
        }
}
