package nl.inholland.appliedmathematics.oop3.moviewatchlist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import nl.inholland.appliedmathematics.oop3.moviewatchlist.exceptions.MovieNotFoundException;
import nl.inholland.appliedmathematics.oop3.moviewatchlist.exceptions.RatingOutOfBoundsException;
import nl.inholland.appliedmathematics.oop3.moviewatchlist.model.Movie;
import nl.inholland.appliedmathematics.oop3.moviewatchlist.model.MovieDTO;
import nl.inholland.appliedmathematics.oop3.moviewatchlist.repository.MovieRepository;
import nl.inholland.appliedmathematics.oop3.moviewatchlist.util.OMDBBasic;
import nl.inholland.appliedmathematics.oop3.moviewatchlist.util.TMDBImagePaths;
import nl.inholland.appliedmathematics.oop3.moviewatchlist.util.TMDBSimilar;

@Service
@AllArgsConstructor
public class MovieService implements IMovieService{

    private final MovieRepository movieRepository;
    private final IImageService imageService;

    @Override
    public void createMovie(MovieDTO movieDTO) {

        System.out.println("Handling POST - adding a movie and downloading images. Time: " + System.currentTimeMillis());

        List<String> myBasic = OMDBBasic.getMovieInfo(movieDTO.movieName());
        List<String> mySimilar = TMDBSimilar.getSimilarMovies(movieDTO.movieName());
        List<String> myImagePaths = TMDBImagePaths.getImageFilePaths(movieDTO.movieName());

        List<String> myFilePaths = new ArrayList<>();

        for (String path : myImagePaths){
            myFilePaths.add(movieDTO.destinationFolder() + path);
        }

        Movie myMovie = Movie.builder()
        .title(myBasic.get(0))
        .releaseYear(Integer.valueOf(myBasic.get(1)))
        .director(myBasic.get(2))
        .genre(myBasic.get(3))
        .similarMovies(mySimilar.toString())
        .filePaths(myFilePaths.toString())
        .watched(movieDTO.watched())
        .rating(movieDTO.rating())
        .build();

        if(myMovie.getRating() < 0 || myMovie.getRating() > 5){
            throw new RatingOutOfBoundsException();
        }

        CompletableFuture<Void> task1 = saveMovieToDB(myMovie);
        CompletableFuture<Void> task2 = imageService.downloadImage(myImagePaths.get(0), movieDTO.destinationFolder());
        CompletableFuture<Void> task3 = imageService.downloadImage(myImagePaths.get(1), movieDTO.destinationFolder());
        CompletableFuture<Void> task4 = imageService.downloadImage(myImagePaths.get(2), movieDTO.destinationFolder());

        CompletableFuture.allOf(task1, task2, task3, task4).join();

        System.out.println("Finished. Time: " + System.currentTimeMillis());
    }


    @Override
    public CompletableFuture<Void> saveMovieToDB(Movie movie) {

        return CompletableFuture.runAsync(() -> {
            System.out.println("Starting the interaction with the DB: " + System.currentTimeMillis());
            movieRepository.save(movie);
            System.out.println("Finished the interaction with the DB: " + System.currentTimeMillis());
        });
        
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> getMovieByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    @Override
    public List<Movie> getMovieByReleaseYear(int releaseYear) {
        return movieRepository.findByReleaseYear(releaseYear);
    }
    
    @Override
    public List<Movie> getMovieByDirector(String director) {
        return movieRepository.findByDirector(director);
    }

    @Override
    public List<Movie> getMovieByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }

    @Override
    public List<Movie> getMovieBySimilarMovies(String similarMovies) {
        return movieRepository.findBySimilarMovies(similarMovies);
    }

    @Override
    public List<Movie> getMovieByFilePaths(String filePaths) {
        return movieRepository.findByFilePaths(filePaths);
    }

    @Override
    public List<Movie> getMovieByWatched(boolean watched) {
        return movieRepository.findByWatched(watched);
    }

    @Override
    public List<Movie> getMovieByRating(int rating) {
        return movieRepository.findByRating(rating);
    }

    @Override
    public Movie updateMovieTitleById(String title, UUID id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException("No movie found with id: " + id));
        movie.setTitle(title);
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovieReleaseYearById(int releaseYear, UUID id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException("No movie found with id: " + id));
        movie.setReleaseYear(releaseYear);
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovieDirectorById(String director, UUID id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException("No movie found with id: " + id));
        movie.setDirector(director);
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovieGenreById(String genre, UUID id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException("No movie found with id: " + id));
        movie.setGenre(genre);
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovieSimilarMoviesById(String similarMovies, UUID id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException("No movie found with id: " + id));
        movie.setSimilarMovies(similarMovies);
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovieFilePathsById(String filePaths, UUID id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException("No movie found with id: " + id));
        movie.setFilePaths(filePaths);
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovieWatchedById(boolean watched, UUID id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException("No movie found with id: " + id));
        movie.setWatched(watched);
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovieRatingById(int rating, UUID id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException("No movie found with id: " + id));
        movie.setRating(rating);
        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovieById(UUID id) {
        movieRepository.deleteById(id);
    }
 
}
