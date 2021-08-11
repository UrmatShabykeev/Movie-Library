package urmatshabykeev.movielibrary.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import urmatshabykeev.movielibrary.models.DTOs.NominationDTO;
import urmatshabykeev.movielibrary.models.entities.Nomination;

import java.util.List;

@Mapper
public interface NominationMapper {
    NominationMapper INSTANCE = Mappers.getMapper(NominationMapper.class);

    Nomination toNomination(NominationDTO nominationDTO);
    NominationDTO toNominationDTO(Nomination nomination);
    List<Nomination> toNominations(List<NominationDTO> nominationDTOS);
    List<NominationDTO> toNominationDTOS(List<Nomination> nominations);
}
