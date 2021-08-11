package urmatshabykeev.movielibrary.services;

import org.springframework.stereotype.Service;
import urmatshabykeev.movielibrary.models.DTOs.NominationDTO;
import urmatshabykeev.movielibrary.models.entities.Nomination;

import java.util.List;

@Service
public interface NominationService {
    NominationDTO createNomination(NominationDTO nominationDTO);
    NominationDTO findNominationById(Long id);
    List<NominationDTO> findAllNominations();
    NominationDTO updateNominationById(NominationDTO nominationDTO);
    NominationDTO deleteNominationById(Long id);
}
