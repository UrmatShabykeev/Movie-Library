package urmatshabykeev.movielibrary.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import urmatshabykeev.movielibrary.models.DTOs.DirectorDTO;
import urmatshabykeev.movielibrary.models.entities.Director;

import java.util.List;

@Mapper
public interface DirectorMapper {
    DirectorMapper INSTANCE = Mappers.getMapper(DirectorMapper.class);

    Director toDirector(DirectorDTO directorDTO);
    DirectorDTO toDirectorDTO(Director director);
    List<Director> toDirectors(List<DirectorDTO> directorDTOS);
    List<DirectorDTO> toDirectorDTOS(List<Director> directors);
}
