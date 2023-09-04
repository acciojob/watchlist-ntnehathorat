package com.driver;


import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Repository
public class MovieRepository {

    HashMap<String,Movie> movieDb = new HashMap<>();
    HashMap<String,Director> directorDb = new HashMap<>();

    HashMap<String, List<String>> movieDirectorDb = new HashMap<>();
    public String addMovie(Movie movie)
    {
        String key = movie.getName();
        movieDb.put(key,movie);
        return  "Movie Added Successfully";
    }

    public String addDirector(Director director)
    {
        String key = director.getName();
        directorDb.put(key,director);
        return  "Director Added Successfully";
    }

    public String addMovieDirectorPair(String movieName, String directorName){
        if(movieDirectorDb.containsKey(directorName)){
            movieDirectorDb.get(directorName).add(movieName);
        }
        else{
            List<String> list = new ArrayList<>();
            list.add(movieName);
            movieDirectorDb.put(directorName, list);
        }
        return "Movie Director Pair added Successfully";
    }

    public List<Movie> getMovieList(){

        List<Movie> movies = new ArrayList<>(movieDb.values());
        return movies;
    }

    public List<Director> getDirectorList(){

        List<Director> directors = new ArrayList<>(directorDb.values());
        return directors;
    }

    public List<String> getDirectorMovieList(String name){

        return movieDirectorDb.get(name);

    }

    public String deleteDirectorAndMovies(String name){

        List<String> movies = movieDirectorDb.get(name);

        for(String movie : movies){
            movieDb.remove(movie);
        }

        directorDb.remove(name);

        movieDirectorDb.remove(name);

        return "Director and its Movie Deleted Successfully";
    }

}
