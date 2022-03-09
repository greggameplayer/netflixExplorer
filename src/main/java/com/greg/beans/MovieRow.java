package com.greg.beans;

import j2html.tags.DomContent;

import static j2html.TagCreator.*;

// A bean which represents a row in the movie table
public class MovieRow {
    private final Movie movie;

    public MovieRow(Movie movie) {
        this.movie = movie;
    }

    public DomContent render() {
        return tr(
                th(movie.getId()).withScope("row"),
                td(movie.getType().getValue()),
                td(movie.getTitle()),
                td(movie.getDirector()),
                td(movie.getCast()),
                td(movie.getCountry()),
                td(movie.getDateAdded()),
                td(a("details").withHref(movie.getId() + ".html").withClasses("btn", "btn-primary", "btn-sm"))
        );
    }
}
