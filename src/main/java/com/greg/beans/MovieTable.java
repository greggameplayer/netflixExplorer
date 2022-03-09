package com.greg.beans;

import j2html.tags.DomContent;
import j2html.tags.specialized.TableTag;
import j2html.tags.specialized.TbodyTag;

import java.util.List;

import static j2html.TagCreator.*;

// A bean which represents a table of movies.
public class MovieTable {
    private final List<Movie> movies;

    public MovieTable(List<Movie> movies) {
        this.movies = movies;
    }

    public DomContent render() {
        TableTag table = new TableTag();
        TbodyTag tbody = new TbodyTag();
        table.with(thead(tr(th("Show id").withScope("col"),
                th("Type").withScope("col"),
                th("Title").withScope("col"),
                th("Director").withScope("col"),
                th("Cast").withScope("col"),
                th("Country").withScope("col"),
                th("Date added").withScope("col"),
                th("More details").withScope("col"))), tbody).withClasses("table", "table-striped", "table-bordered", "table-hover", "table-sm");
        movies.forEach(movie -> tbody.with(new MovieRow(movie).render()));

        return table;
    }
}
