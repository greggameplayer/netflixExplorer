package com.greg.factories;

import com.greg.beans.Movie;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

class MovieFactoryTest {
    static Movie movie;
    static List<Movie> movies = new ArrayList<>();

    @BeforeAll
    static void setUp(){
        MovieFactory movieFactory = new MovieFactory();
        movie = movieFactory.createMovie(new String[] {"s1", "Movie", "The Matrix", "Director", "Cast", "US", "2018", "1999", "4.5", "40min", "Action", "The Matrix is a 1999 American epic science fiction film directed by The Wachowskis, starring Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss, Hugo Weaving, and Joe Pantoliano."});
        movies.add(movie);
        movies.add(movieFactory.createMovie(new String[] {"s2", "Movie", "The Matrix: Reloaded", "Director", "Cast", "US", "2018", "2003", "4.5", "40min", "Action", "The Matrix: Reloaded is a 2003 American epic science fiction film directed by The Wachowskis, starring Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss, Hugo Weaving, and Joe Pantoliano."}));
    }

    @Test
    void createMovieTest() {
        Assertions.assertEquals("The Matrix", movie.getTitle());
        Assertions.assertEquals("Director", movie.getDirector());
        Assertions.assertEquals("Cast", movie.getCast());
        Assertions.assertEquals("US", movie.getCountry());
        Assertions.assertEquals("2018", movie.getDateAdded());
        Assertions.assertEquals("1999", movie.getReleaseYear());
        Assertions.assertEquals("4.5", movie.getRating());
        Assertions.assertEquals("40min", movie.getDuration());
        Assertions.assertEquals("Action", movie.getListedIn());
        Assertions.assertEquals("s1", movie.getId());
        Assertions.assertEquals("The Matrix is a 1999 American epic science fiction film directed by The Wachowskis, starring Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss, Hugo Weaving, and Joe Pantoliano.", movie.getDescription());
    }

    @Test
    void createMoviesTest() {
        Assertions.assertEquals(2, movies.size());
        Assertions.assertEquals("The Matrix", movies.get(0).getTitle());
        Assertions.assertEquals("The Matrix: Reloaded", movies.get(1).getTitle());
        Assertions.assertEquals("Director", movies.get(0).getDirector());
        Assertions.assertEquals("Director", movies.get(1).getDirector());
        Assertions.assertEquals("Cast", movies.get(0).getCast());
        Assertions.assertEquals("Cast", movies.get(1).getCast());
        Assertions.assertEquals("US", movies.get(0).getCountry());
        Assertions.assertEquals("US", movies.get(1).getCountry());
        Assertions.assertEquals("2018", movies.get(0).getDateAdded());
        Assertions.assertEquals("2018", movies.get(1).getDateAdded());
        Assertions.assertEquals("1999", movies.get(0).getReleaseYear());
        Assertions.assertEquals("2003", movies.get(1).getReleaseYear());
        Assertions.assertEquals("4.5", movies.get(0).getRating());
        Assertions.assertEquals("4.5", movies.get(1).getRating());
        Assertions.assertEquals("40min", movies.get(0).getDuration());
        Assertions.assertEquals("40min", movies.get(1).getDuration());
        Assertions.assertEquals("Action", movies.get(0).getListedIn());
        Assertions.assertEquals("Action", movies.get(1).getListedIn());
        Assertions.assertEquals("s1", movies.get(0).getId());
        Assertions.assertEquals("s2", movies.get(1).getId());
        Assertions.assertEquals("The Matrix is a 1999 American epic science fiction film directed by The Wachowskis, starring Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss, Hugo Weaving, and Joe Pantoliano.", movies.get(0).getDescription());
        Assertions.assertEquals("The Matrix: Reloaded is a 2003 American epic science fiction film directed by The Wachowskis, starring Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss, Hugo Weaving, and Joe Pantoliano.", movies.get(1).getDescription());
    }
}
