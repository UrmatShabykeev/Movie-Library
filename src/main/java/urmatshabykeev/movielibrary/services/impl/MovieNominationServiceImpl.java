package urmatshabykeev.movielibrary.services.impl;

import com.sun.org.apache.bcel.internal.generic.MONITORENTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urmatshabykeev.movielibrary.dao.MovieNominationRepository;
import urmatshabykeev.movielibrary.errors.CreateEntityException;
import urmatshabykeev.movielibrary.errors.DeleteEntityException;
import urmatshabykeev.movielibrary.errors.NoDataFoundException;
import urmatshabykeev.movielibrary.errors.UpdateEntityException;
import urmatshabykeev.movielibrary.mappers.MovieNominationMapper;
import urmatshabykeev.movielibrary.models.DTOs.MovieNominationDTO;
import urmatshabykeev.movielibrary.models.entities.MovieNomination;
import urmatshabykeev.movielibrary.services.MovieNominationService;

import java.util.List;

@Service
public class MovieNominationServiceImpl implements MovieNominationService {
    @Autowired
    private MovieNominationRepository movieNominationRepository;

    private MovieNominationMapper movieNominationMapper = MovieNominationMapper.INSTANCE;

    @Override
    public List<MovieNominationDTO> findAllMovieNominations(){
        List<MovieNomination> movieNominations = movieNominationRepository.findAll();

        if(movieNominations.isEmpty()) {
            throw new NoDataFoundException();
        }

        List<MovieNominationDTO> movieNominationDTOS = movieNominationMapper.toMovieNominationDTOS(movieNominations);

        return movieNominationDTOS;
    }

    @Override
    public MovieNominationDTO findMovieNominationById(Long id){
        MovieNomination movieNomination;

        movieNomination = movieNominationRepository.findById(id).orElseThrow(
                    () -> new NoDataFoundException());

        MovieNominationDTO movieNominationDTO = movieNominationMapper.toMovieNominationDTO(movieNomination);
        return movieNominationDTO;
    }

    @Override
    public MovieNominationDTO createMovieNomination(MovieNominationDTO movieNominationDTO){
        try{
            MovieNomination movieNomination = movieNominationMapper.toMovieNomination(movieNominationDTO);

            movieNominationRepository.save(movieNomination);
        }catch (Exception e) {
            throw new CreateEntityException("MovieNomination");
        }

        return movieNominationDTO;
    }

    @Override
    public MovieNominationDTO deleteMovieNominationById(Long id){
        MovieNomination movieNomination = movieNominationRepository.findById(id).orElseThrow(
                ()-> new NoDataFoundException()
        );
        MovieNominationDTO movieNominationDTO = movieNominationMapper.toMovieNominationDTO(movieNomination);

        try{
            movieNominationRepository.deleteById(id);
        }
        catch (Exception e) {
            throw new DeleteEntityException("MovieNomination", id);
        }

        return movieNominationDTO;
    }

    @Override
    public MovieNominationDTO updateMovieNominationById(MovieNominationDTO movieNominationDTO){
        MovieNomination movieNomination = movieNominationRepository.findById(movieNominationDTO.getId()).orElseThrow(
                ()-> new NoDataFoundException()
        );

        movieNomination = movieNominationMapper.toMovieNomination(movieNominationDTO);

        try{
            movieNominationRepository.save(movieNomination);
        }catch (Exception e) {
            throw new UpdateEntityException("MovieNomination", movieNominationDTO.getId());
        }

        MovieNominationDTO movieNominationDTO1 = movieNominationMapper.toMovieNominationDTO(movieNomination);

        return movieNominationDTO1;
    }
}
