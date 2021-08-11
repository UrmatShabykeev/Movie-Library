package urmatshabykeev.movielibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import urmatshabykeev.movielibrary.models.DTOs.MovieNominationDTO;
import urmatshabykeev.movielibrary.models.entities.MovieNomination;
import urmatshabykeev.movielibrary.services.MovieNominationService;

import java.util.List;

@RestController
@RequestMapping("/movieNominations")
public class MovieNominationController {
    @Autowired
    private MovieNominationService movieNominationService;

    @GetMapping("/getMovieNominationById")
    public ResponseEntity<MovieNominationDTO> getMovieNominationById(@RequestParam Long id){
        MovieNominationDTO movieNominationDTO = movieNominationService.findMovieNominationById(id);
        return new ResponseEntity<>(movieNominationDTO, HttpStatus.OK);
    }

    @GetMapping("/getAllMovieNominations")
    public ResponseEntity<List<MovieNominationDTO>> getAllMovieNominations(){
        List<MovieNominationDTO> movieNominationDTOS = movieNominationService.findAllMovieNominations();
        return new ResponseEntity<>(movieNominationDTOS, HttpStatus.OK);
    }

    @PutMapping("/createMovieNomination")
    public  ResponseEntity<MovieNominationDTO> createMovieNomination(@RequestBody MovieNominationDTO movieNominationDTO){
        MovieNominationDTO movieNominationDTO1 = movieNominationService.createMovieNomination(movieNominationDTO);
        return new ResponseEntity<>(movieNominationDTO1, HttpStatus.OK);
    }

    @DeleteMapping("/deleteMovieNominationById")
    public ResponseEntity<MovieNominationDTO> deleteMovieNominationById(@RequestParam Long id){
        MovieNominationDTO movieNominationDTO = movieNominationService.deleteMovieNominationById(id);
        return new ResponseEntity<>(movieNominationDTO, HttpStatus.OK);
    }

    @PutMapping("/updateMovieNominationById")
    public ResponseEntity<MovieNominationDTO> updateMovieNominationById(@RequestBody MovieNominationDTO movieNominationDTO){
        MovieNominationDTO movieNominationDTO1 = movieNominationService.updateMovieNominationById(movieNominationDTO);
        return new ResponseEntity<>(movieNominationDTO1, HttpStatus.OK);
    }
}
