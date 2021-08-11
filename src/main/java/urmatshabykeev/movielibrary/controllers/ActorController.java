package urmatshabykeev.movielibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import urmatshabykeev.movielibrary.models.DTOs.ActorDTO;
import urmatshabykeev.movielibrary.models.DTOs.WriterDTO;
import urmatshabykeev.movielibrary.services.ActorService;
import urmatshabykeev.movielibrary.services.WriterService;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {
    @Autowired
    private ActorService actorService;

    @GetMapping("/getAllActors")
    public ResponseEntity<List<ActorDTO>> getAllActors(){
        List<ActorDTO> actorDTOS = actorService.findAllActors();
        return new ResponseEntity<>(actorDTOS, HttpStatus.OK);
    }

    @GetMapping("/getActorById")
    public ResponseEntity<ActorDTO> getActorById(@RequestParam Long id){
        ActorDTO actorDTO = actorService.findActorById(id);
        return new ResponseEntity<>(actorDTO, HttpStatus.OK);
    }

    @PostMapping("/createActor")
    public ResponseEntity<ActorDTO> createDirector(@RequestBody ActorDTO actorDTO){
        ActorDTO actorDTO1 = actorService.createActor(actorDTO);
        return new ResponseEntity<>(actorDTO1, HttpStatus.OK);
    }

    @PutMapping("/updateActorById")
    public ResponseEntity<ActorDTO> updateActorById(@RequestBody ActorDTO actorDTO){
        ActorDTO actorDTO1 = actorService.updateActorById(actorDTO);
        return new ResponseEntity<>(actorDTO1, HttpStatus.OK);
    }

    @DeleteMapping("/deleteActorById")
    public ResponseEntity<ActorDTO> deleteActorById(@RequestParam Long id){
        ActorDTO actorDTO = actorService.deleteActorById(id);
        return new ResponseEntity<>(actorDTO, HttpStatus.OK);
    }
}
