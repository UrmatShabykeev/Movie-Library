package urmatshabykeev.movielibrary.services;

import org.springframework.stereotype.Service;
import urmatshabykeev.movielibrary.models.DTOs.DirectorDTO;

import java.util.List;

@Service
public interface DirectorService {
    DirectorDTO createDirector(DirectorDTO directorDTO);
    DirectorDTO findDirectorById(Long id);
    List<DirectorDTO> findAllDirectors();
    DirectorDTO updateDirectorById(DirectorDTO directorDTO);
    DirectorDTO deleteDirectorById(Long id);

}
