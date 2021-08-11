package urmatshabykeev.movielibrary.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urmatshabykeev.movielibrary.dao.NominationRepository;
import urmatshabykeev.movielibrary.errors.CreateEntityException;
import urmatshabykeev.movielibrary.errors.DeleteEntityException;
import urmatshabykeev.movielibrary.errors.NoDataFoundException;
import urmatshabykeev.movielibrary.errors.UpdateEntityException;
import urmatshabykeev.movielibrary.mappers.NominationMapper;
import urmatshabykeev.movielibrary.models.DTOs.NominationDTO;
import urmatshabykeev.movielibrary.models.entities.Nomination;
import urmatshabykeev.movielibrary.services.NominationService;

import java.util.List;

@Service
public class NominationServiceImpl implements NominationService {
    @Autowired
    private NominationRepository nominationRepository;

    private NominationMapper nominationMapper = NominationMapper.INSTANCE;

    @Override
    public List<NominationDTO> findAllNominations(){
        List<NominationDTO> nominationDTOS = nominationMapper.toNominationDTOS(nominationRepository.findAll());
        if (nominationDTOS.isEmpty()) {
            throw new NoDataFoundException();
        }

        return nominationDTOS;
    }

    @Override
    public NominationDTO findNominationById(Long id){
        NominationDTO nominationDTO = nominationMapper.toNominationDTO(nominationRepository.findById(id).orElseThrow(
                () -> new NoDataFoundException()
        ));

        return nominationDTO;
    }

    @Override
    public NominationDTO createNomination(NominationDTO nominationDTO){
        try{
            Nomination nomination = nominationMapper.toNomination(nominationDTO);
            /*nomination.setNominationName(nominationDTO.getNominationName());
            nomination.setPrize(nominationDTO.getPrize());*/

            nominationRepository.save(nomination);

            nominationDTO = nominationMapper.toNominationDTO(nomination);
        }catch (Exception e){
            throw new CreateEntityException("Nomination");
        }

        return nominationDTO;
    }

    @Override
    public NominationDTO updateNominationById(NominationDTO nominationDTO){
        Nomination nomination = nominationRepository.findById(nominationDTO.getId()).orElseThrow(
                () -> new NoDataFoundException()
        );

        nomination.setNominationName(nominationDTO.getNominationName());
        nomination.setPrize(nominationDTO.getPrize());

        try{
            nominationRepository.save(nomination);
        }catch (Exception e){
            throw new UpdateEntityException("Nomination", nominationDTO.getId());
        }

        NominationDTO nominationDTO1 = nominationMapper.toNominationDTO(nomination);
        nominationDTO1.setNominationName(nomination.getNominationName());
        nominationDTO1.setPrize(nomination.getPrize());

        return nominationDTO1;
    }

    @Override
    public NominationDTO deleteNominationById(Long id){
        NominationDTO nominationDTO;
        try{
            nominationDTO = nominationMapper.toNominationDTO(nominationRepository.findById(id).orElseThrow(
                    () -> new NoDataFoundException()
            ));

            nominationRepository.deleteById(id);
        }catch (Exception e){
            throw new DeleteEntityException("Nomination", id);
        }

        return nominationDTO;
    }
}
