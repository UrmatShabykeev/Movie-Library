package urmatshabykeev.movielibrary.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urmatshabykeev.movielibrary.dao.SexRepository;
import urmatshabykeev.movielibrary.errors.CreateEntityException;
import urmatshabykeev.movielibrary.errors.DeleteEntityException;
import urmatshabykeev.movielibrary.errors.NoDataFoundException;
import urmatshabykeev.movielibrary.errors.UpdateEntityException;
import urmatshabykeev.movielibrary.mappers.SexMapper;
import urmatshabykeev.movielibrary.models.DTOs.SexDTO;
import urmatshabykeev.movielibrary.models.entities.Sex;
import urmatshabykeev.movielibrary.services.SexService;

import java.util.List;

@Service
public class SexServiceImpl implements SexService {

    @Autowired
    private SexRepository sexRepository;

    private SexMapper sexMapper = SexMapper.INSTANCE;

    @Override
    public SexDTO createSex(SexDTO sexDTO) {
        try{
            Sex sex = sexMapper.toSex(sexDTO);
            sex.setSexName(sexDTO.getSexName());
            sexRepository.save(sex);
        }catch (Exception e) {
            throw new CreateEntityException("sex");
        }

        return sexDTO;
    }

    @Override
    public SexDTO deleteSexById(Long id){
        SexDTO sexDTO;
        try{
             sexDTO = sexMapper.toSexDTO(sexRepository.findById(id).orElseThrow( () ->
                     new NoDataFoundException()));
             sexRepository.deleteById(id);
        }catch (Exception e) {
            throw new DeleteEntityException("sex", id);
        }

        return sexDTO;
    }

    @Override
    public SexDTO findSexById(Long id) {

        SexDTO sexDTO = sexMapper.toSexDTO(sexRepository.findById(id).
                orElseThrow( () ->
                        new NoDataFoundException())
        );

        return sexDTO;
    }

    @Override
    public SexDTO updateSexById(SexDTO sexDTO){
        Sex sex = sexRepository.findById(sexDTO.getId()).orElseThrow(
                () -> new NoDataFoundException()
        );

        sex.setSexName(sexDTO.getSexName());
        try{
            sexRepository.save(sex);
        }catch (Exception e){
            throw new UpdateEntityException("sex", sexDTO.getId());
        }

        SexDTO sexDTO1 = sexMapper.toSexDTO(sex);
        sexDTO1.setSexName(sex.getSexName());
        return sexDTO1;
    }

    @Override
    public List<SexDTO> findAllSexes(){
        List<SexDTO> sexDTOS = sexMapper.toSexDTOs(sexRepository.findAll());

        if (sexDTOS.isEmpty()) {
            throw new NoDataFoundException();
        }

        return sexDTOS;
    }
}
