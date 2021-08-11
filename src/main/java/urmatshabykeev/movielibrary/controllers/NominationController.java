package urmatshabykeev.movielibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import urmatshabykeev.movielibrary.models.DTOs.CountryDTO;
import urmatshabykeev.movielibrary.models.DTOs.NominationDTO;
import urmatshabykeev.movielibrary.services.CountryService;
import urmatshabykeev.movielibrary.services.NominationService;

import java.util.List;

@RestController
@RequestMapping("/nominations")
public class NominationController {
    @Autowired
    private NominationService nominationService;

    @GetMapping("/getNominationById")
    public ResponseEntity<NominationDTO> getNominationById(@RequestParam Long id) {
        NominationDTO nominationDTO = nominationService.findNominationById(id);
        return new ResponseEntity<>(nominationDTO, HttpStatus.OK);
    }

    @GetMapping("/getAllNominations")
    public ResponseEntity<List<NominationDTO>> getAllNominations() {
        List<NominationDTO> nominationDTO = nominationService.findAllNominations();
        return new ResponseEntity<>(nominationDTO, HttpStatus.OK);
    }

    @PostMapping("/createNomination")
    public ResponseEntity<NominationDTO> createNomination(@RequestBody NominationDTO nominationDTO){
        System.out.println("sdfasdfasdfasdf");
        NominationDTO nomination = nominationService.createNomination(nominationDTO);
        return new ResponseEntity<>(nomination, HttpStatus.OK);
    }

    @DeleteMapping("/deleteNominationById")
    public ResponseEntity<NominationDTO> deleteCountryById(@RequestParam Long id){
        NominationDTO nominationDTO = nominationService.deleteNominationById(id);
        return new ResponseEntity<>(nominationDTO, HttpStatus.OK);
    }

    @PutMapping("/updateNominationById")
    public ResponseEntity<NominationDTO> updateCountryById(@RequestBody NominationDTO nominationDTO){
        NominationDTO nominationDTO1 = nominationService.updateNominationById(nominationDTO);
        return new ResponseEntity<>(nominationDTO1, HttpStatus.OK);
    }
}
