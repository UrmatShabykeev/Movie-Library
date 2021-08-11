package urmatshabykeev.movielibrary.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import urmatshabykeev.movielibrary.dao.CountryRepository;
import urmatshabykeev.movielibrary.errors.CreateEntityException;
import urmatshabykeev.movielibrary.errors.DeleteEntityException;
import urmatshabykeev.movielibrary.errors.NoDataFoundException;
import urmatshabykeev.movielibrary.errors.UpdateEntityException;
import urmatshabykeev.movielibrary.mappers.CountryMapper;
import urmatshabykeev.movielibrary.models.DTOs.CountryDTO;
import urmatshabykeev.movielibrary.models.entities.Country;
import urmatshabykeev.movielibrary.services.CountryService;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    private CountryMapper countryMapper = CountryMapper.INSTANCE;

    @Override
    public List<CountryDTO> findAllCountries(){
        List<CountryDTO> countryDTOS = countryMapper.toCountryDTOS(countryRepository.findAll());
        if (countryDTOS.isEmpty()) {
            throw new NoDataFoundException();
        }

        return countryDTOS;
    }

    @Override
    public CountryDTO findCountryById(Long id){
        CountryDTO countryDTO = countryMapper.toCountryDTO(countryRepository.findById(id).orElseThrow(
                () -> new NoDataFoundException()
        ));

        return countryDTO;
    }

    @Override
    public CountryDTO createCountry(CountryDTO countryDTO){
        try{
            Country country = countryMapper.toCountry(countryDTO);

            countryRepository.save(country);

            countryDTO = countryMapper.toCountryDTO(country);
        }catch (Exception e){
            throw new CreateEntityException("Country");
        }

        return countryDTO;
    }

    @Override
    public CountryDTO updateCountryById(CountryDTO countryDTO){
        Country country = countryRepository.findById(countryDTO.getId()).orElseThrow(
                () -> new NoDataFoundException()
        );
        country.setCountryName(countryDTO.getCountryName());

        try{
            countryRepository.save(country);
        }catch (Exception e){
            throw new UpdateEntityException("Country", countryDTO.getId());
        }

        CountryDTO countryDTO1 = countryMapper.toCountryDTO(country);
        return countryDTO1;
    }

    @Override
    public CountryDTO deleteCountryById(Long id){
        CountryDTO countryDTO;
        try{
            countryDTO = countryMapper.toCountryDTO(countryRepository.findById(id).orElseThrow(
                    () -> new NoDataFoundException()
            ));

            countryRepository.deleteById(id);
        }catch (Exception e){
            throw new DeleteEntityException("Country", id);
        }

        return countryDTO;
    }
}
