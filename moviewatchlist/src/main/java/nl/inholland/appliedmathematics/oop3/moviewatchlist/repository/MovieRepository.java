package nl.inholland.appliedmathematics.oop3.moviewatchlist.repository;

import nl.inholland.appliedmathematics.oop3.moviewatchlist.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.List;

/**
 * Repository interface for Movie entity.
 * Provides CRUD operations and custom query methods through JpaRepository.
 */
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

    // Update
    Movie updateTitleById(String title, UUID id);
    Movie updateReleaseYearById(int releaseYear, UUID id);
    Movie updateDirectorById(String director, UUID id);
    Movie updateGenreById(String genre, UUID id);
    Movie updateSimilarMoviesById(String similarMovies, UUID id);
    Movie updateFilePathsById(String filePaths, UUID id);
    Movie updateWatchedById(boolean watched, UUID id);
    Movie updateRatingById(int rating, UUID id);

}
