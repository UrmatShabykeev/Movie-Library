package urmatshabykeev.movielibrary.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import urmatshabykeev.movielibrary.models.DTOs.ActorDTO;
import urmatshabykeev.movielibrary.models.entities.Actor;

import java.util.List;

@Mapper
public interface ActorMapper {
    ActorMapper INSTANCE = Mappers.getMapper(ActorMapper.class);

    Actor toActor(ActorDTO writerDTO);
    ActorDTO toActorDTO(Actor writer);
    List<Actor> toActors(List<ActorDTO> writerDTOS);
    List<ActorDTO> toActorDTOS(List<Actor> writers);
}
