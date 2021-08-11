package urmatshabykeev.movielibrary.services;

import org.springframework.stereotype.Service;
import urmatshabykeev.movielibrary.models.DTOs.PrizeDTO;

import java.util.List;

@Service
public interface PrizeService {
    PrizeDTO createPrize(PrizeDTO prizeDTO);
    PrizeDTO findPrizeById(Long id);
    List<PrizeDTO> findAllPrizes();
    PrizeDTO updatePrizeById(PrizeDTO prizeDTO);
    PrizeDTO deletePrizeById(Long id);
}
