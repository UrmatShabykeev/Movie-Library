package urmatshabykeev.movielibrary.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import urmatshabykeev.movielibrary.models.DTOs.SexDTO;
import urmatshabykeev.movielibrary.models.entities.Sex;

import java.util.List;

@Mapper
public interface SexMapper {
    SexMapper INSTANCE = Mappers.getMapper(SexMapper.class);

    Sex toSex(SexDTO sexDTO);
    SexDTO toSexDTO(Sex sex);
    List<SexDTO> toSexDTOs(List<Sex> sexes);
    List<Sex> toSexes(List<SexDTO> sexDTOS);
}
