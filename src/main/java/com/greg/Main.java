package com.greg;

import com.greg.beans.Movie;
import com.greg.factories.HtmlFactory;
import com.greg.factories.MovieFactory;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String targetDir = System.getProperty("user.dir"); // get current project directory

        MovieFactory movieFactory = new MovieFactory();
        HtmlFactory htmlFactory = new HtmlFactory();
        String netflixCSV = (args.length > 0) ? args[0] : targetDir + "/assets/netflix_titles.csv"; // get csv file path

        try (FileWriter fw = new FileWriter(Paths.get(targetDir) + "/homepage.html");
             Stream<String> stream = Files.lines(Paths.get(netflixCSV))) { // read csv file and open file writer
            List<String[]> moviesData = stream.skip(1).map(s -> s.split("\\|")).collect(Collectors.toList()); // skip header and map movie properties to array
            List<Movie> movies = movieFactory.createMovies(moviesData); // create movies from a list of movie properties

            fw.write(htmlFactory.createMovieListPage(movies)); // write html file

            for (Movie movie : movies) {
                try (FileWriter fw2 = new FileWriter(Paths.get(targetDir) + "/" + movie.getId() + ".html")) { // open file writer for each movie
                    fw2.write(htmlFactory.createMoviePage(movie)); // write html file
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
