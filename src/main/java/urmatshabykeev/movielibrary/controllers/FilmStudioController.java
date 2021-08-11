package urmatshabykeev.movielibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import urmatshabykeev.movielibrary.models.DTOs.FilmStudioDTO;
import urmatshabykeev.movielibrary.services.FilmStudioService;

import java.util.List;

@RestController
@RequestMapping("/filmStudios")
public class FilmStudioController {
    @Autowired
    private FilmStudioService filmStudioService;

    @GetMapping("/getFilmStudioById")
    public ResponseEntity<FilmStudioDTO> getCountryById(@RequestParam Long id) {
        FilmStudioDTO filmStudioDTO = filmStudioService.findFilmStudioById(id);
        return new ResponseEntity<>(filmStudioDTO, HttpStatus.OK);
    }

    @GetMapping("/getAllFilmStudios")
    public ResponseEntity<List<FilmStudioDTO>> getAllCountries() {
        List<FilmStudioDTO> filmStudioDTO = filmStudioService.findAllFilmStudios();
        return new ResponseEntity<>(filmStudioDTO, HttpStatus.OK);
    }

    @PostMapping("/createFilmStudio")
    public ResponseEntity<FilmStudioDTO> createCountry(@RequestBody FilmStudioDTO filmStudioDTO){
        FilmStudioDTO filmStudio = filmStudioService.createFilmStudio(filmStudioDTO);
        return new ResponseEntity<>(filmStudio, HttpStatus.OK);
    }

    @DeleteMapping("/deleteFilmStudioById")
    public ResponseEntity<FilmStudioDTO> deleteCountryById(@RequestParam Long id){
        FilmStudioDTO filmStudioDTO = filmStudioService.deleteFilmStudioById(id);
        return new ResponseEntity<>(filmStudioDTO, HttpStatus.OK);
    }

    @PutMapping("/updateFilmStudioById")
    public ResponseEntity<FilmStudioDTO> updateCountryById(@RequestBody FilmStudioDTO filmStudioDTO){
        FilmStudioDTO filmStudioDTO1 = filmStudioService.updateFilmStudioById(filmStudioDTO);
        return new ResponseEntity<>(filmStudioDTO1, HttpStatus.OK);
    }
}
