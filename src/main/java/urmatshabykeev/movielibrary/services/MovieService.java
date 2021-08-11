package urmatshabykeev.movielibrary.services;

import org.springframework.stereotype.Service;
import urmatshabykeev.movielibrary.models.DTOs.MovieDTO;

import java.util.List;

@Service
public interface MovieService {
    MovieDTO createMovie(MovieDTO directorDTO);
    MovieDTO findMovieById(Long id);
    List<MovieDTO> findAllMovies();
    MovieDTO updateMovieById(MovieDTO directorDTO);
    MovieDTO deleteMovieById(Long id);
}
