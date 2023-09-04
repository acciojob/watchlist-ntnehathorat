package com.driver;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
      MovieRepository movieRepository = new MovieRepository();
    public String addMovie(Movie movie)
    {
        if(movie.getName().equals(null)){
            return "Enter Valid Movie Name";
        }
        if(movie.getDurationInMinutes() <= 0){
            return "Enter Valid Movie Duration";
        }
        if(movie.getImdbRating() < 0){
            return "Rating Invalid!";
        }

        String ans = movieRepository.addMovie(movie);

        return ans;
    }

    public String addDirector(Director director)
    {
        if(director.getName().equals(null)){
            return "Enter Valid Director Name";
        }

        if(director.getImdbRating() < 0){
            return "Rating Invalid!";
        }

        String ans = movieRepository.addDirector(director);

        return ans;
    }

    public String addMovieDirectorPair(String movieName, String directorName){

        String ans = movieRepository.addMovieDirectorPair(movieName, directorName);

        return ans;
    }


    public Movie getMovieByName(String name){

        List<Movie> movieList = movieRepository.getMovieList();

        Movie ans = null;

        for(Movie movie : movieList){
            if(movie.getName().equals(name)){
                ans = movie;
            }
        }
        return ans;
    }

    public Director getDirectorByName(String name){

        List<Director> directorList = movieRepository.getDirectorList();

        Director ans = null;

        for(Director director : directorList){
            if(director.getName().equals(name)){
                ans = director;
            }
        }
        return ans;
    }

    public List<String> getMoviesByDirectorName(String name){

        List<String> list = movieRepository.getDirectorMovieList(name);

        return list;
    }

    public List<String> findAllMovies(){

        List<Movie> movieList = movieRepository.getMovieList();

        List<String> movies = new ArrayList<>();

        for(Movie movie : movieList){
            movies.add(movie.getName());
        }

        return movies;
    }

    public String deleteDirectorByName(String name){
        String ans = movieRepository.deleteDirectorAndMovies(name);
        return ans;
    }

    public String deleteAllDirectors(){

        List<Director> directorList = movieRepository.getDirectorList();

        for(Director director : directorList){
            deleteDirectorByName(director.getName());
        }

        return "Directors and their movies has been deleted Successfully";
    }


}
