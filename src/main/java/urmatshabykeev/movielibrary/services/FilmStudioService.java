package urmatshabykeev.movielibrary.services;

import org.springframework.stereotype.Service;
import urmatshabykeev.movielibrary.models.DTOs.FilmStudioDTO;

import java.util.List;

@Service
public interface FilmStudioService {
    FilmStudioDTO createFilmStudio(FilmStudioDTO sexDTO);
    FilmStudioDTO deleteFilmStudioById(Long id);
    FilmStudioDTO findFilmStudioById(Long id);
    FilmStudioDTO updateFilmStudioById(FilmStudioDTO sexDTO);
    List<FilmStudioDTO> findAllFilmStudios();
}
