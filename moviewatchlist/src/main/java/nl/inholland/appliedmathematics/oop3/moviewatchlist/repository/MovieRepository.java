package nl.inholland.appliedmathematics.oop3.moviewatchlist.repository;

import nl.inholland.appliedmathematics.oop3.moviewatchlist.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.List;

// Repository interface for Movie entity.
// Provides CRUD operations and custom query methods through JpaRepository.
// However, the update operations are in the MovieService class since the JpaRepository has no
// way of recognising method names that start with update as update operations.

@Repository
public interface MovieRepository extends JpaRepository<Movie, UUID>{

    // Read
    List<Movie> findByTitle(String title);
    List<Movie> findByReleaseYear(int releaseYear);
    List<Movie> findByDirector(String director);
    List<Movie> findByGenre(String genre);
    List<Movie> findBySimilarMovies(String similarMovies);
    List<Movie> findByFilePaths(String filePaths);
    List<Movie> findByWatched(boolean watched);
    List<Movie> findByRating(int rating);

}
