package urmatshabykeev.movielibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import urmatshabykeev.movielibrary.models.DTOs.DirectorDTO;
import urmatshabykeev.movielibrary.models.entities.Director;
import urmatshabykeev.movielibrary.services.DirectorService;

import java.util.List;

@RestController
@RequestMapping("/directors")
public class DirectorController {
    @Autowired
    private DirectorService directorService;

    @GetMapping("/getAllDirectors")
    public ResponseEntity<List<DirectorDTO>> getAllDirectors(){
        List<DirectorDTO> directorDTOS = directorService.findAllDirectors();
        return new ResponseEntity<>(directorDTOS, HttpStatus.OK);
    }

    @GetMapping("/getDirectorById")
    public ResponseEntity<DirectorDTO> getDirectorById(@RequestParam Long id){
        DirectorDTO directorDTO = directorService.findDirectorById(id);
        return new ResponseEntity<>(directorDTO, HttpStatus.OK);
    }

    @PostMapping("/createDirector")
    public ResponseEntity<DirectorDTO> createDirector(@RequestBody DirectorDTO directorDTO){
        DirectorDTO directorDTO1 = directorService.createDirector(directorDTO);
        return new ResponseEntity<>(directorDTO1, HttpStatus.OK);
    }

    @PutMapping("/updateDirectorById")
    public ResponseEntity<DirectorDTO> updateDirectorById(@RequestBody DirectorDTO directorDTO){
        DirectorDTO directorDTO1 = directorService.updateDirectorById(directorDTO);
        return new ResponseEntity<>(directorDTO1, HttpStatus.OK);
    }

    @DeleteMapping("/deleteDirectorById")
    public ResponseEntity<DirectorDTO> deleteDirectorById(@RequestParam Long id){
        DirectorDTO directorDTO = directorService.deleteDirectorById(id);
        return new ResponseEntity<>(directorDTO, HttpStatus.OK);
    }
}
