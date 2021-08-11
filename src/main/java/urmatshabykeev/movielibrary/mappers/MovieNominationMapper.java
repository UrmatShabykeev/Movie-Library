package urmatshabykeev.movielibrary.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import urmatshabykeev.movielibrary.models.DTOs.MovieNominationDTO;
import urmatshabykeev.movielibrary.models.entities.MovieNomination;

import java.util.List;

@Mapper
public interface MovieNominationMapper {
    MovieNominationMapper INSTANCE = Mappers.getMapper(MovieNominationMapper.class);

    MovieNomination toMovieNomination(MovieNominationDTO movieNominationDTO);
    MovieNominationDTO toMovieNominationDTO(MovieNomination movieNomination);
    List<MovieNomination> toMovieNominations(List<MovieNominationDTO> movieNominationDTOS);
    List<MovieNominationDTO> toMovieNominationDTOS(List<MovieNomination> movieNominations);
}
