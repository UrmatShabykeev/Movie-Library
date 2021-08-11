package urmatshabykeev.movielibrary.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urmatshabykeev.movielibrary.dao.DirectorRepository;
import urmatshabykeev.movielibrary.errors.CreateEntityException;
import urmatshabykeev.movielibrary.errors.DeleteEntityException;
import urmatshabykeev.movielibrary.errors.NoDataFoundException;
import urmatshabykeev.movielibrary.errors.UpdateEntityException;
import urmatshabykeev.movielibrary.mappers.DirectorMapper;
import urmatshabykeev.movielibrary.models.DTOs.DirectorDTO;
import urmatshabykeev.movielibrary.models.entities.Director;
import urmatshabykeev.movielibrary.services.DirectorService;

import javax.websocket.OnError;
import java.util.List;

@Service
public class DirectorServiceImpl implements DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    private DirectorMapper directorMapper = DirectorMapper.INSTANCE;

    @Override
    public DirectorDTO createDirector(DirectorDTO directorDTO){
        try{
            Director director = directorMapper.toDirector(directorDTO);

            directorRepository.save(director);

            directorDTO = directorMapper.toDirectorDTO(director);
        }catch (Exception e){
            throw new CreateEntityException("Director");
        }

        return directorDTO;
    }

    @Override
    public List<DirectorDTO> findAllDirectors(){
        List<DirectorDTO> directorDTOS = directorMapper.toDirectorDTOS(directorRepository.findAll());

        if(directorDTOS.isEmpty()){
            throw  new NoDataFoundException();
        }

        return directorDTOS;
    }

    @Override
    public DirectorDTO findDirectorById(Long id){
        DirectorDTO directorDTO = directorMapper.toDirectorDTO(directorRepository.findById(id).orElseThrow(
                () -> new NoDataFoundException()
        ));

        return directorDTO;
    }

    @Override
    public DirectorDTO deleteDirectorById(Long id){
        DirectorDTO directorDTO;

        try{
            directorDTO = directorMapper.toDirectorDTO(directorRepository.findById(id).orElseThrow(
                    () -> new NoDataFoundException()
            ));

            directorRepository.deleteById(id);
        }catch (Exception e){
            throw new DeleteEntityException("Director", id);
        }

        return directorDTO;
    }

    @Override
    public DirectorDTO updateDirectorById(DirectorDTO directorDTO){
        Director director = directorRepository.findById(directorDTO.getId()).orElseThrow(
                () -> new NoDataFoundException()
        );
        director = directorMapper.toDirector(directorDTO);

        try{
            directorRepository.save(director);
        }catch (Exception e){
            throw new UpdateEntityException("Director", directorDTO.getId());
        }

        DirectorDTO directorDTO1 = directorMapper.toDirectorDTO(director);
        return directorDTO1;
    }
}
