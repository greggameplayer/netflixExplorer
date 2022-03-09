package com.greg.factories;

import com.greg.beans.Movie;
import com.greg.beans.MovieTable;
import com.greg.beans.Page;

import javax.inject.Singleton;
import java.util.List;

// Generate HTML from Data
@Singleton
public class HtmlFactory {

    // Create a page with a table of movies
    public String createMovieListPage(List<Movie> movies) {
        Page page = new Page("Movie List");
        MovieTable movieTable = new MovieTable(movies);
        page.setBody(movieTable.render());
        return page.render();
    }

    // Create a page with the details of a movie
    public String createMoviePage(Movie movie) {
        Page page = new Page("Movie");
        page.setBody(movie.render());
        return page.render();
    }
}
