package com.greg.factories;

import com.greg.beans.Movie;
import com.greg.enums.MediaTypeEnum;

import javax.inject.Singleton;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.pivovarit.function.ThrowingFunction.unchecked;

@Singleton
public class MovieFactory {
    public Movie createMovie(String[] movieData) {
        Movie movie = new Movie();
        movie.setId(movieData[0]);
        movie.setType(MediaTypeEnum.fromString(movieData[1]));
        movie.setTitle(movieData[2]);
        movie.setDirector(movieData[3]);
        movie.setCast(movieData[4]);
        movie.setCountry(movieData[5]);
        movie.setDateAdded(movieData[6]);
        movie.setReleaseYear(movieData[7]);
        movie.setRating(movieData[8]);
        movie.setDuration(movieData[9]);
        movie.setListedIn(movieData[10]);
        movie.setDescription(movieData[11]);

        return movie;
    }

    public List<Movie> createMovies(List<String[]> movieData) {
        return movieData.stream().map(unchecked(this::createMovie)).sorted(Comparator.comparing(Movie::getType).thenComparing(Movie::getTitle)).collect(Collectors.toList());
    }
}
