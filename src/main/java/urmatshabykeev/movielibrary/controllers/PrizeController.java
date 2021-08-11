package urmatshabykeev.movielibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import urmatshabykeev.movielibrary.models.DTOs.PrizeDTO;
import urmatshabykeev.movielibrary.models.entities.Prize;
import urmatshabykeev.movielibrary.services.PrizeService;

import java.util.List;

@RestController
@RequestMapping("/prizes")
public class PrizeController {
    @Autowired
    private PrizeService prizeService;

    @GetMapping("/getPrizeById")
    public ResponseEntity<PrizeDTO> getPrizeById(@RequestParam Long id) {
        PrizeDTO countryDTO = prizeService.findPrizeById(id);
        return new ResponseEntity<>(countryDTO, HttpStatus.OK);
    }

    @GetMapping("/getAllPrizes")
    public ResponseEntity<List<PrizeDTO>> getAllCountries() {
        List<PrizeDTO> prizeDTO = prizeService.findAllPrizes();
        return new ResponseEntity<>(prizeDTO, HttpStatus.OK);
    }

    @PostMapping("/createPrize")
    public ResponseEntity<PrizeDTO> createCountry(@RequestBody PrizeDTO prizeDTO){
        PrizeDTO prize = prizeService.createPrize(prizeDTO);
        return new ResponseEntity<>(prize, HttpStatus.OK);
    }

    @DeleteMapping("/deletePrizeById")
    public ResponseEntity<PrizeDTO> deletePrizeById(@RequestParam Long id){
        PrizeDTO prizeDTO = prizeService.deletePrizeById(id);
        return new ResponseEntity<>(prizeDTO, HttpStatus.OK);
    }

    @PutMapping("/updatePrizeById")
    public ResponseEntity<PrizeDTO> updatePrizeDTOById(@RequestBody PrizeDTO prizeDTO){
        PrizeDTO prizeDTO1 = prizeService.updatePrizeById(prizeDTO);
        return new ResponseEntity<>(prizeDTO1, HttpStatus.OK);
    }

}
