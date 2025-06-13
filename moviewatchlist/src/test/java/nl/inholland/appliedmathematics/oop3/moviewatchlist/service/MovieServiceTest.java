package nl.inholland.appliedmathematics.oop3.moviewatchlist.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import nl.inholland.appliedmathematics.oop3.moviewatchlist.model.Movie;
import nl.inholland.appliedmathematics.oop3.moviewatchlist.repository.MovieRepository;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @Mock
    private IImageService imageService;

    @InjectMocks
    private MovieService movieService;

    @BeforeEach
    void setup() {
        // Optional: Setup before each test
    }

    @Test
    void testGetMovieNamesByRatingBound_HigherTrue() {
        List<Movie> mockMovies = List.of(
            Movie.builder().title("Interstellar").rating(5).build(),
            Movie.builder().title("The Room").rating(2).build()
        );

        Mockito.when(movieRepository.findAll()).thenReturn(mockMovies);

        List<String> result = movieService.getMovieNamesByRatingBound(3, true);

        Assertions.assertEquals(List.of("Interstellar"), result);
    }

    @Test
    void testIsBetweenYearBounds_true() {
        List<Movie> mockMovies = List.of(
            Movie.builder().releaseYear(2010).build(),
            Movie.builder().releaseYear(2020).build()
        );

        Mockito.when(movieRepository.findAll()).thenReturn(mockMovies);

        boolean result = movieService.isBetweenYearBounds(2005, 2015);

        Assertions.assertTrue(result);
    }

    @Test
    void testGetDirectorRating() {
        List<Movie> mockMovies = List.of(
            Movie.builder().director("Nolan").rating(5).build(),
            Movie.builder().director("Nolan").rating(3).build()
        );

        Mockito.when(movieRepository.findAll()).thenReturn(mockMovies);

        float rating = movieService.getDirectorRating("Nolan");

        Assertions.assertEquals(4.0, rating);
    }

}
