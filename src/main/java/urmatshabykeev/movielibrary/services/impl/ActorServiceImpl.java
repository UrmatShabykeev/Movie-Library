package urmatshabykeev.movielibrary.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urmatshabykeev.movielibrary.dao.ActorRepository;
import urmatshabykeev.movielibrary.errors.CreateEntityException;
import urmatshabykeev.movielibrary.errors.DeleteEntityException;
import urmatshabykeev.movielibrary.errors.NoDataFoundException;
import urmatshabykeev.movielibrary.errors.UpdateEntityException;
import urmatshabykeev.movielibrary.mappers.ActorMapper;
import urmatshabykeev.movielibrary.models.DTOs.ActorDTO;
import urmatshabykeev.movielibrary.models.entities.Actor;
import urmatshabykeev.movielibrary.services.ActorService;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {
    @Autowired
    private ActorRepository actorRepository;

    ActorMapper actorMapper = ActorMapper.INSTANCE;

    @Override
    public ActorDTO createActor(ActorDTO actorDTO){
        try{
            Actor actor = actorMapper.toActor(actorDTO);

            actorRepository.save(actor);

            actorDTO = actorMapper.toActorDTO(actor);
        }catch (Exception e){
            throw new CreateEntityException("Actor");
        }

        return actorDTO;
    }

    @Override
    public List<ActorDTO> findAllActors(){
        List<ActorDTO> actorDTOS = actorMapper.toActorDTOS(actorRepository.findAll());

        if(actorDTOS.isEmpty()){
            throw  new NoDataFoundException();
        }

        return actorDTOS;
    }

    @Override
    public ActorDTO findActorById(Long id){
        ActorDTO actorDTO = actorMapper.toActorDTO(actorRepository.findById(id).orElseThrow(
                () -> new NoDataFoundException()
        ));

        return actorDTO;
    }

    @Override
    public ActorDTO deleteActorById(Long id){
        ActorDTO actorDTO;

        try{
            actorDTO = actorMapper.toActorDTO(actorRepository.findById(id).orElseThrow(
                    () -> new NoDataFoundException()
            ));

            actorRepository.deleteById(id);
        }catch (Exception e){
            throw new DeleteEntityException("Actor", id);
        }

        return actorDTO;
    }

    @Override
    public ActorDTO updateActorById(ActorDTO actorDTO){
        Actor actor = actorRepository.findById(actorDTO.getId()).orElseThrow(
                () -> new NoDataFoundException()
        );
        actor = actorMapper.toActor(actorDTO);

        try{
            actorRepository.save(actor);
        }catch (Exception e){
            throw new UpdateEntityException("Actor", actorDTO.getId());
        }

        ActorDTO actorDTO1 = actorMapper.toActorDTO(actor);
        return actorDTO1;
    }
}
