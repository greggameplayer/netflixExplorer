package com.greg.beans;

import com.greg.enums.MediaTypeEnum;
import j2html.tags.DomContent;

import java.util.Objects;

import static j2html.TagCreator.*;

// A bean which represents a movie
public class Movie {
    private String id;
    private MediaTypeEnum type;
    private String title;
    private String director;
    private String cast;
    private String country;
    private String dateAdded;
    private String releaseYear;
    private String rating;
    private String duration;
    private String listedIn;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MediaTypeEnum getType() {
        return type;
    }

    public void setType(MediaTypeEnum type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getListedIn() {
        return listedIn;
    }

    public void setListedIn(String listedIn) {
        this.listedIn = listedIn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Movie details rendering
    public DomContent render() {
        final String rowStyle = "display: flex; flex-direction: row; align-items: center;";
        final String defaultMargin = "margin-left: 1em;";
        return div(
                div(h1(title).withClasses("display-2", "text-primary")).withStyle(rowStyle + "margin-left: 1em; margin-top: 1em;"),
                new SimpleField(type.getValue(), "fas", "fa-film", "me-2"),
                new SimpleField(duration, "fas", "fa-clock", "me-2"),
                new SimpleField(releaseYear, "fas", "fa-calendar", "me-2"),
                new SimpleField(country, "fas", "fa-globe-europe", "me-2"),
                (!Objects.equals(director, "")) ? new SimpleField(director, "fas", "fa-user-tie", "me-2") : null,
                (!Objects.equals(cast, "")) ? new SimpleField("Cast(s) : " + cast, "fas", "fa-users", "me-2") : null,
                new SimpleField(rating, "fas", "fa-star", "me-2"),
                div(p("Categories : " + listedIn)).withStyle(rowStyle + defaultMargin),
                p(description).withStyle(defaultMargin + "width: 80%; display: flex;")
        );
    }
}
