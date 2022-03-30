package com.greg.factories;

import com.greg.beans.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class HtmlFactoryTest {
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
    void createMoviePageTest() {
        HtmlFactory htmlFactory = new HtmlFactory();
        String result = htmlFactory.createMoviePage(movie);
        Assertions.assertEquals("<html><head><title>Movie</title><link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"><script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script><link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\" rel=\"stylesheet\"></head><body><div><div style=\"display: flex; flex-direction: row; align-items: center;margin-left: 1em; margin-top: 1em;\"><h1 class=\"display-2 text-primary\">The Matrix</h1></div><SimpleField><div style=\"display: flex; flex-direction: row; align-items: center;margin-left: 1em;\"><i class=\"fas fa-film me-2\" style=\"margin-bottom: 1rem;\"></i><p class=\"text-muted\">Movie</p></div></SimpleField><SimpleField><div style=\"display: flex; flex-direction: row; align-items: center;margin-left: 1em;\"><i class=\"fas fa-clock me-2\" style=\"margin-bottom: 1rem;\"></i><p class=\"text-muted\">40min</p></div></SimpleField><SimpleField><div style=\"display: flex; flex-direction: row; align-items: center;margin-left: 1em;\"><i class=\"fas fa-calendar me-2\" style=\"margin-bottom: 1rem;\"></i><p class=\"text-muted\">1999</p></div></SimpleField><SimpleField><div style=\"display: flex; flex-direction: row; align-items: center;margin-left: 1em;\"><i class=\"fas fa-globe-europe me-2\" style=\"margin-bottom: 1rem;\"></i><p class=\"text-muted\">US</p></div></SimpleField><SimpleField><div style=\"display: flex; flex-direction: row; align-items: center;margin-left: 1em;\"><i class=\"fas fa-user-tie me-2\" style=\"margin-bottom: 1rem;\"></i><p class=\"text-muted\">Director</p></div></SimpleField><SimpleField><div style=\"display: flex; flex-direction: row; align-items: center;margin-left: 1em;\"><i class=\"fas fa-users me-2\" style=\"margin-bottom: 1rem;\"></i><p class=\"text-muted\">Cast(s) : Cast</p></div></SimpleField><SimpleField><div style=\"display: flex; flex-direction: row; align-items: center;margin-left: 1em;\"><i class=\"fas fa-star me-2\" style=\"margin-bottom: 1rem;\"></i><p class=\"text-muted\">4.5</p></div></SimpleField><div style=\"display: flex; flex-direction: row; align-items: center;margin-left: 1em;\"><p>Categories : Action</p></div><p style=\"margin-left: 1em;width: 80%; display: flex;\">The Matrix is a 1999 American epic science fiction film directed by The Wachowskis, starring Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss, Hugo Weaving, and Joe Pantoliano.</p></div></body></html>", result);
    }

    @Test
    void createMovieListPage() {
        HtmlFactory htmlFactory = new HtmlFactory();
        String result = htmlFactory.createMovieListPage(movies);
        Assertions.assertEquals("<html><head><title>Movie List</title><link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"><script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script><link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\" rel=\"stylesheet\"></head><body><table class=\"table table-striped table-bordered table-hover table-sm\"><thead><tr><th scope=\"col\">Show id</th><th scope=\"col\">Type</th><th scope=\"col\">Title</th><th scope=\"col\">Director</th><th scope=\"col\">Cast</th><th scope=\"col\">Country</th><th scope=\"col\">Date added</th><th scope=\"col\">More details</th></tr></thead><tbody><tr><th scope=\"row\">s1</th><td>Movie</td><td>The Matrix</td><td>Director</td><td>Cast</td><td>US</td><td>2018</td><td><a href=\"s1.html\" class=\"btn btn-primary btn-sm\">details</a></td></tr><tr><th scope=\"row\">s2</th><td>Movie</td><td>The Matrix: Reloaded</td><td>Director</td><td>Cast</td><td>US</td><td>2018</td><td><a href=\"s2.html\" class=\"btn btn-primary btn-sm\">details</a></td></tr></tbody></table></body></html>", result);
    }
}
