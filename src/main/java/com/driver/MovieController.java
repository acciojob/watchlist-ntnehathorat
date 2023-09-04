package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService = new MovieService();

    //   1. Add a movie: POST /movies/add-movie
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie)
    {
      String ans = movieService.addMovie(movie);
      return new ResponseEntity<>(ans , HttpStatus.CREATED);

    }

    //   2. Add a director: POST /movies/add-director
    @PostMapping("/add-director")
    public  ResponseEntity<String> addDirector(@RequestBody Director director)
    {
        String ans =  movieService.addDirector(director);
        return  new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    //   3.  Pair an existing movie and director: PUT /movies/add-movie-director-pair

    @PostMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movieName")String movieName, @RequestParam("directorName")String directorName){
        String ans = movieService.addMovieDirectorPair(movieName, directorName);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    //   4.  Get Movie by movie name: GET /movies/get-movie-by-name/{name}

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@RequestParam("name")String name){
        Movie movie = movieService.getMovieByName(name);
        return new ResponseEntity<>(movie, HttpStatus.FOUND);
    }

    //   5.  Get Director by director name: GET /movies/get-director-by-name/{name}
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@RequestParam("name")String name){
        Director director = movieService.getDirectorByName(name);
        return new ResponseEntity<>(director,HttpStatus.FOUND);
    }

    //   6.  Get List of movies name for a given director name: GET /movies/get-movies-by-director-name/{director}

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@RequestParam("name")String name){
        List<String> movies = movieService.getMoviesByDirectorName(name);
        return new ResponseEntity<>(movies, HttpStatus.FOUND);
    }

    //   7.  Get List of all movies added: GET /movies/get-all-movies

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> movies = movieService.findAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.FOUND);
    }


    //   8.  Delete a director and its movies from the records: DELETE /movies/delete-director-by-name

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name")String name){
        String ans = movieService.deleteDirectorByName(name);
        return new ResponseEntity<>(ans, HttpStatus.ACCEPTED);
    }

    //   9.  Delete all directors and all movies by them from the records: DELETE /movies/delete-all-directors

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        String ans = movieService.deleteAllDirectors();
        return new ResponseEntity<>(ans, HttpStatus.ACCEPTED);
    }

}
