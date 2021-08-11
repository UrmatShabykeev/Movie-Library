package urmatshabykeev.movielibrary.services;

import org.springframework.stereotype.Service;
import urmatshabykeev.movielibrary.models.DTOs.CountryDTO;
import urmatshabykeev.movielibrary.models.entities.Country;

import java.util.List;

@Service
public interface CountryService {
    CountryDTO createCountry(CountryDTO countryDTO);
    CountryDTO findCountryById(Long id);
    List<CountryDTO> findAllCountries();
    CountryDTO updateCountryById(CountryDTO countryDTO);
    CountryDTO deleteCountryById(Long id);
}
