package urmatshabykeev.movielibrary.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urmatshabykeev.movielibrary.dao.FilmStudioRepository;
import urmatshabykeev.movielibrary.errors.CreateEntityException;
import urmatshabykeev.movielibrary.errors.DeleteEntityException;
import urmatshabykeev.movielibrary.errors.NoDataFoundException;
import urmatshabykeev.movielibrary.errors.UpdateEntityException;
import urmatshabykeev.movielibrary.mappers.FilmStudioMapper;
import urmatshabykeev.movielibrary.models.DTOs.FilmStudioDTO;
import urmatshabykeev.movielibrary.models.entities.FilmStudio;
import urmatshabykeev.movielibrary.services.FilmStudioService;

import java.util.List;

@Service
public class FilmStudioImpl implements FilmStudioService {
    @Autowired
    private FilmStudioRepository filmStudioRepository;

    private FilmStudioMapper filmStudioMapper = FilmStudioMapper.INSTANCE;

    @Override
    public List<FilmStudioDTO> findAllFilmStudios(){
        List<FilmStudioDTO> filmStudioDTOS = filmStudioMapper.toFilmStudioDTOS(filmStudioRepository.findAll());
        if (filmStudioDTOS.isEmpty()) {
            throw new NoDataFoundException();
        }

        return filmStudioDTOS;
    }

    @Override
    public FilmStudioDTO findFilmStudioById(Long id){
        FilmStudioDTO filmStudioDTO = filmStudioMapper.toFilmStudioDTO(filmStudioRepository.findById(id).orElseThrow(
                () -> new NoDataFoundException()
        ));

        return filmStudioDTO;
    }

    @Override
    public FilmStudioDTO createFilmStudio(FilmStudioDTO filmStudioDTO){
        try{
            FilmStudio filmStudio = filmStudioMapper.toFilmStudio(filmStudioDTO);
            filmStudio.setFilmStudioName(filmStudioDTO.getFilmStudioName());

            filmStudioRepository.save(filmStudio);

            filmStudioDTO = filmStudioMapper.toFilmStudioDTO(filmStudio);
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new CreateEntityException("FilmStudio");
        }

        return filmStudioDTO;
    }

    @Override
    public FilmStudioDTO updateFilmStudioById(FilmStudioDTO filmStudioDTO){
        FilmStudio filmStudio = filmStudioRepository.findById(filmStudioDTO.getId()).orElseThrow(
                () -> new NoDataFoundException()
        );

        filmStudioDTO.setFilmStudioName(filmStudioDTO.getFilmStudioName());
        try{
            filmStudioRepository.save(filmStudio);
        }catch (Exception e){
            throw new UpdateEntityException("FilmStudio", filmStudioDTO.getId());
        }

        FilmStudioDTO filmStudioDTO1 = filmStudioMapper.toFilmStudioDTO(filmStudio);
        filmStudioDTO1.setFilmStudioName(filmStudio.getFilmStudioName());
        return filmStudioDTO1;
    }

    @Override
    public FilmStudioDTO deleteFilmStudioById(Long id){
        FilmStudioDTO filmStudioDTO;
        try{
            filmStudioDTO = filmStudioMapper.toFilmStudioDTO(filmStudioRepository.findById(id).orElseThrow(
                    () -> new NoDataFoundException()
            ));

            filmStudioRepository.deleteById(id);
        }catch (Exception e){
            throw new DeleteEntityException("FilmStudio", id);
        }

        return filmStudioDTO;
    }

}
