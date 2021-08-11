package urmatshabykeev.movielibrary.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urmatshabykeev.movielibrary.dao.PrizeRepository;
import urmatshabykeev.movielibrary.errors.CreateEntityException;
import urmatshabykeev.movielibrary.errors.DeleteEntityException;
import urmatshabykeev.movielibrary.errors.NoDataFoundException;
import urmatshabykeev.movielibrary.errors.UpdateEntityException;
import urmatshabykeev.movielibrary.mappers.PrizeMapper;
import urmatshabykeev.movielibrary.models.DTOs.PrizeDTO;
import urmatshabykeev.movielibrary.models.entities.Prize;
import urmatshabykeev.movielibrary.services.PrizeService;

import java.util.List;

@Service
public class PrizeServiceImpl implements PrizeService {
    @Autowired
    private PrizeRepository prizeRepository;

    private PrizeMapper prizeMapper = PrizeMapper.INSTANCE;

    @Override
    public List<PrizeDTO> findAllPrizes(){
        List<PrizeDTO> prizeDTOS = prizeMapper.toPrizeDTOS(prizeRepository.findAll());
        if (prizeDTOS.isEmpty()) {
            throw new NoDataFoundException();
        }

        return prizeDTOS;
    }

    @Override
    public PrizeDTO findPrizeById(Long id){
        PrizeDTO prizeDTO = prizeMapper.toPrizeDTO(prizeRepository.findById(id).orElseThrow(
                () -> new NoDataFoundException()
        ));

        return prizeDTO;
    }

    @Override
    public PrizeDTO createPrize(PrizeDTO prizeDTO){
        try{
            Prize prize = prizeMapper.toPrize(prizeDTO);
            prize.setPrizeName(prizeDTO.getPrizeName());

            prizeRepository.save(prize);

            prizeDTO = prizeMapper.toPrizeDTO(prize);
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new CreateEntityException("Prize");
        }



        return prizeDTO;
    }

    @Override
    public PrizeDTO updatePrizeById(PrizeDTO prizeDTO){
        Prize prize = prizeRepository.findById(prizeDTO.getId()).orElseThrow(
                () -> new NoDataFoundException()
        );

        prize.setPrizeName(prizeDTO.getPrizeName());
        try{
            prizeRepository.save(prize);
        }catch (Exception e){
            throw new UpdateEntityException("Prize", prizeDTO.getId());
        }

        PrizeDTO prizeDTO1 = prizeMapper.toPrizeDTO(prize);
        prizeDTO1.setPrizeName(prize.getPrizeName());
        return prizeDTO1;
    }

    @Override
    public PrizeDTO deletePrizeById(Long id){
        PrizeDTO prizeDTO;
        try{
            prizeDTO = prizeMapper.toPrizeDTO(prizeRepository.findById(id).orElseThrow(
                    () -> new NoDataFoundException()
            ));

            prizeRepository.deleteById(id);
        }catch (Exception e){
            throw new DeleteEntityException("Country", id);
        }

        return prizeDTO;


    }
}
