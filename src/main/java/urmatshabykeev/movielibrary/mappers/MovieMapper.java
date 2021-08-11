package urmatshabykeev.movielibrary.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import urmatshabykeev.movielibrary.models.DTOs.MovieDTO;
import urmatshabykeev.movielibrary.models.DTOs.WriterDTO;
import urmatshabykeev.movielibrary.models.entities.Movie;
import urmatshabykeev.movielibrary.models.entities.Writer;

import java.util.List;

@Mapper
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    Movie toMovie(MovieDTO movieDTO);
    MovieDTO toMovieDTO(Movie movie);
    List<Movie> toMovies(List<MovieDTO> movieDTOS);
    List<MovieDTO> toMovieDTOS(List<Movie> movies);
}
