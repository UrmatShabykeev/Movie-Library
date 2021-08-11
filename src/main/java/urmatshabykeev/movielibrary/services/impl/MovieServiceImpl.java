package urmatshabykeev.movielibrary.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urmatshabykeev.movielibrary.dao.MovieRepository;
import urmatshabykeev.movielibrary.errors.CreateEntityException;
import urmatshabykeev.movielibrary.errors.DeleteEntityException;
import urmatshabykeev.movielibrary.errors.NoDataFoundException;
import urmatshabykeev.movielibrary.errors.UpdateEntityException;
import urmatshabykeev.movielibrary.mappers.MovieMapper;
import urmatshabykeev.movielibrary.models.DTOs.MovieDTO;
import urmatshabykeev.movielibrary.models.entities.Movie;
import urmatshabykeev.movielibrary.services.MovieService;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    private MovieMapper movieMapper = MovieMapper.INSTANCE;
    
    @Override
    public MovieDTO createMovie(MovieDTO movieDTO){
        try{
            Movie movie = movieMapper.toMovie(movieDTO);

            movieRepository.save(movie);

            movieDTO = movieMapper.toMovieDTO(movie);
        }catch (Exception e){
            throw new CreateEntityException("Movie");
        }

        return movieDTO;
    }

    @Override
    public List<MovieDTO> findAllMovies(){
        List<MovieDTO> movieDTOS = movieMapper.toMovieDTOS(movieRepository.findAll());

        if(movieDTOS.isEmpty()){
            throw  new NoDataFoundException();
        }

        return movieDTOS;
    }

    @Override
    public MovieDTO findMovieById(Long id){
        MovieDTO movieDTO = movieMapper.toMovieDTO(movieRepository.findById(id).orElseThrow(
                () -> new NoDataFoundException()
        ));

        return movieDTO;
    }

    @Override
    public MovieDTO deleteMovieById(Long id){
        MovieDTO movieDTO;

        try{
            movieDTO = movieMapper.toMovieDTO(movieRepository.findById(id).orElseThrow(
                    () -> new NoDataFoundException()
            ));

            movieRepository.deleteById(id);
        }catch (Exception e){
            throw new DeleteEntityException("Movie", id);
        }

        return movieDTO;
    }

    @Override
    public MovieDTO updateMovieById(MovieDTO MovieDTO){
        Movie movie = movieRepository.findById(MovieDTO.getId()).orElseThrow(
                () -> new NoDataFoundException()
        );
        movie = movieMapper.toMovie(MovieDTO);

        try{
            movieRepository.save(movie);
        }catch (Exception e){
            throw new UpdateEntityException("Movie", MovieDTO.getId());
        }

        MovieDTO movieDTO1 = movieMapper.toMovieDTO(movie);
        return movieDTO1;
    }
}
