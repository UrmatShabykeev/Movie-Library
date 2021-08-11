package urmatshabykeev.movielibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import urmatshabykeev.movielibrary.models.DTOs.CountryDTO;
import urmatshabykeev.movielibrary.services.CountryService;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/getCountryById")
    public ResponseEntity<CountryDTO> getCountryById(@RequestParam Long id) {
        CountryDTO countryDTO = countryService.findCountryById(id);
        return new ResponseEntity<>(countryDTO, HttpStatus.OK);
    }

    @GetMapping("/getAllCountries")
    public ResponseEntity<List<CountryDTO>> getAllCountries() {
        List<CountryDTO> countryDTO = countryService.findAllCountries();
        return new ResponseEntity<>(countryDTO, HttpStatus.OK);
    }

    @PostMapping("/createCountry")
    public ResponseEntity<CountryDTO> createCountry(@RequestBody CountryDTO countryDTO){
        CountryDTO country = countryService.createCountry(countryDTO);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCountryById")
    public ResponseEntity<CountryDTO> deleteCountryById(@RequestParam Long id){
        CountryDTO countryDTO = countryService.deleteCountryById(id);
        return new ResponseEntity<>(countryDTO, HttpStatus.OK);
    }

    @PutMapping("/updateCountryById")
    public ResponseEntity<CountryDTO> updateCountryById(@RequestBody CountryDTO countryDTO){
        CountryDTO countryDTO1 = countryService.updateCountryById(countryDTO);
        return new ResponseEntity<>(countryDTO1, HttpStatus.OK);
    }
}
