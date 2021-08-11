package urmatshabykeev.movielibrary.mappers;

import org.hibernate.procedure.spi.ParameterRegistrationImplementor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import urmatshabykeev.movielibrary.models.DTOs.PrizeDTO;
import urmatshabykeev.movielibrary.models.entities.Prize;

import java.util.List;

@Mapper
public interface PrizeMapper {
    PrizeMapper INSTANCE = Mappers.getMapper(PrizeMapper.class);

    Prize toPrize(PrizeDTO prizeDTO);
    PrizeDTO toPrizeDTO(Prize prize);
    List<Prize> toPrizes(List<PrizeDTO> prizeDTOS);
    List<PrizeDTO> toPrizeDTOS(List<Prize> prizes);
}
