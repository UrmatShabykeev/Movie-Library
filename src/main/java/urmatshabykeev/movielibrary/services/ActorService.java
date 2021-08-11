package urmatshabykeev.movielibrary.services;

import org.springframework.stereotype.Service;
import urmatshabykeev.movielibrary.models.DTOs.ActorDTO;
import urmatshabykeev.movielibrary.models.entities.Actor;

import java.util.List;

@Service
public interface ActorService {
    ActorDTO createActor(ActorDTO actorDTO);
    ActorDTO deleteActorById(Long id);
    ActorDTO updateActorById(ActorDTO actorDTO);
    List<ActorDTO> findAllActors();
    ActorDTO findActorById(Long id);
}
