package urmatshabykeev.movielibrary.services;

import org.springframework.stereotype.Service;
import urmatshabykeev.movielibrary.models.DTOs.SexDTO;

import java.util.List;

@Service
public interface SexService {
    SexDTO createSex(SexDTO sexDTO);
    SexDTO deleteSexById(Long id);
    SexDTO findSexById(Long id);
    SexDTO updateSexById(SexDTO sexDTO);
    List<SexDTO> findAllSexes();
}
