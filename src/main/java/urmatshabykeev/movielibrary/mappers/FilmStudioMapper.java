package urmatshabykeev.movielibrary.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import urmatshabykeev.movielibrary.models.DTOs.FilmStudioDTO;
import urmatshabykeev.movielibrary.models.entities.FilmStudio;

import java.util.List;

@Mapper
public interface FilmStudioMapper {
    FilmStudioMapper INSTANCE = Mappers.getMapper(FilmStudioMapper.class);

    FilmStudio toFilmStudio(FilmStudioDTO filmStudioDTO);
    FilmStudioDTO toFilmStudioDTO(FilmStudio filmStudio);
    List<FilmStudio> toFilmStudios(List<FilmStudioDTO> filmStudioDTOS);
    List<FilmStudioDTO> toFilmStudioDTOS(List<FilmStudio> filmStudios);
}
