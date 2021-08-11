package urmatshabykeev.movielibrary.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import urmatshabykeev.movielibrary.models.DTOs.CountryDTO;
import urmatshabykeev.movielibrary.models.entities.Country;

import javax.persistence.ManyToOne;
import java.util.List;

@Mapper
public interface CountryMapper {
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    CountryDTO toCountryDTO(Country country);
    Country toCountry(CountryDTO countryDTO);
    List<Country> toCountries(List<CountryDTO> countryDTOS);
    List<CountryDTO> toCountryDTOS(List<Country> countries);
}
