package urmatshabykeev.movielibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import urmatshabykeev.movielibrary.models.DTOs.MovieDTO;
import urmatshabykeev.movielibrary.services.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/getAllMovies")
    public ResponseEntity<List<MovieDTO>> getAllWriters(){
        List<MovieDTO> movieDTOS = movieService.findAllMovies();
        return new ResponseEntity<>(movieDTOS, HttpStatus.OK);
    }

    @GetMapping("/getMovieById")
    public ResponseEntity<MovieDTO> getMovieById(@RequestParam Long id){
        MovieDTO movieDTO = movieService.findMovieById(id);
        return new ResponseEntity<>(movieDTO, HttpStatus.OK);
    }

    @PostMapping("/creatMovie")
    public ResponseEntity<MovieDTO> createMovie(@RequestBody MovieDTO movieDTO){
        MovieDTO movieDTO1 = movieService.createMovie(movieDTO);
        return new ResponseEntity<>(movieDTO1, HttpStatus.OK);
    }

    @PutMapping("/updateMovieById")
    public ResponseEntity<MovieDTO> updateMovieById(@RequestBody MovieDTO movieDTO){
        MovieDTO movieDTO1 = movieService.updateMovieById(movieDTO);
        return new ResponseEntity<>(movieDTO1, HttpStatus.OK);
    }

    @DeleteMapping("/deleteMovieById")
    public ResponseEntity<MovieDTO> deleteMovieById(@RequestParam Long id){
        MovieDTO movieDTO = movieService.deleteMovieById(id);
        return new ResponseEntity<>(movieDTO, HttpStatus.OK);
    }
}
