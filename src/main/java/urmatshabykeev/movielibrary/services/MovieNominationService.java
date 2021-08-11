package urmatshabykeev.movielibrary.services;

import org.springframework.stereotype.Service;
import urmatshabykeev.movielibrary.models.DTOs.MovieNominationDTO;
import urmatshabykeev.movielibrary.models.entities.MovieNomination;

import java.util.List;

@Service
public interface MovieNominationService {
    MovieNominationDTO createMovieNomination(MovieNominationDTO movieNominationDTO);
    MovieNominationDTO updateMovieNominationById(MovieNominationDTO movieNominationDTO);
    MovieNominationDTO deleteMovieNominationById(Long id);
    MovieNominationDTO findMovieNominationById(Long id);
    List<MovieNominationDTO> findAllMovieNominations();
}
