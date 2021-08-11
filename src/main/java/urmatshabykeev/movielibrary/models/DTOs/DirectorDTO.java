package urmatshabykeev.movielibrary.models.DTOs;

import lombok.Data;
import urmatshabykeev.movielibrary.models.entities.Country;
import urmatshabykeev.movielibrary.models.entities.Sex;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class DirectorDTO {
    private Long id;
    private String directorName;
    private Sex sex;
    private Date dateOfBirth;
    private Date dateOfDeath;
    private Country country;
    private BigDecimal totalEarnings;
}
