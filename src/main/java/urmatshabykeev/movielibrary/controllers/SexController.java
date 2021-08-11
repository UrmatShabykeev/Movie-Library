package urmatshabykeev.movielibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import urmatshabykeev.movielibrary.models.DTOs.SexDTO;
import urmatshabykeev.movielibrary.services.SexService;

import java.util.List;

@RestController
@RequestMapping("/sexes")
public class SexController {
    @Autowired
    private SexService sexService;

    @PostMapping("/createSex")
    public ResponseEntity<SexDTO> createSex(@RequestBody SexDTO sexDTO) {
        SexDTO sex = sexService.createSex(sexDTO);
        return new ResponseEntity<>(sex, HttpStatus.OK);
    }

    @DeleteMapping("/deleteSexById")
    public ResponseEntity<SexDTO> deleteSexById(@RequestParam Long id){
        SexDTO sexDTO = sexService.deleteSexById(id);
        return new ResponseEntity<>(sexDTO, HttpStatus.OK);
    }

    @GetMapping("/getAllSexes")
    public ResponseEntity<List<SexDTO>> getAllSexex(){
        List<SexDTO> sexDTOS = sexService.findAllSexes();
        return new ResponseEntity<>(sexDTOS, HttpStatus.OK);
    }

    @GetMapping("/getSexById")
    public ResponseEntity<SexDTO> getSexById(@RequestParam Long id){
        SexDTO sexDTO = sexService.findSexById(id);
        return new ResponseEntity<>(sexDTO, HttpStatus.OK);
    }

    @PutMapping("/updateSexById")
    public ResponseEntity<SexDTO> updateSexById(@RequestBody SexDTO sexDTO){
        SexDTO sexDTO1 = sexService.updateSexById(sexDTO);
        return new ResponseEntity<>(sexDTO1, HttpStatus.OK);
    }
}
