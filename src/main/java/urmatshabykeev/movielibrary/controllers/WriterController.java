package urmatshabykeev.movielibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import urmatshabykeev.movielibrary.models.DTOs.WriterDTO;
import urmatshabykeev.movielibrary.services.WriterService;

import java.util.List;

@RestController
@RequestMapping("/writers")
public class WriterController {
    @Autowired
    private WriterService writerService;

    @GetMapping("/getAllWriters")
    public ResponseEntity<List<WriterDTO>> getAllWriters(){
        List<WriterDTO> writerDTOS = writerService.findAllWriters();
        return new ResponseEntity<>(writerDTOS, HttpStatus.OK);
    }

    @GetMapping("/getWriterById")
    public ResponseEntity<WriterDTO> getWriterById(@RequestParam Long id){
        WriterDTO writerDTO = writerService.findWriterById(id);
        return new ResponseEntity<>(writerDTO, HttpStatus.OK);
    }

    @PostMapping("/createWriter")
    public ResponseEntity<WriterDTO> createWriter(@RequestBody WriterDTO writerDTO){
        WriterDTO writerDTO1 = writerService.createWriter(writerDTO);
        return new ResponseEntity<>(writerDTO1, HttpStatus.OK);
    }

    @PutMapping("/updateWriterById")
    public ResponseEntity<WriterDTO> updateWriterById(@RequestBody WriterDTO writerDTO){
        WriterDTO writerDTO1 = writerService.updateWriterById(writerDTO);
        return new ResponseEntity<>(writerDTO1, HttpStatus.OK);
    }

    @DeleteMapping("/deleteWriterById")
    public ResponseEntity<WriterDTO> deleteWriterById(@RequestParam Long id){
        WriterDTO writerDTO = writerService.deleteWriterById(id);
        return new ResponseEntity<>(writerDTO, HttpStatus.OK);
    }
}
