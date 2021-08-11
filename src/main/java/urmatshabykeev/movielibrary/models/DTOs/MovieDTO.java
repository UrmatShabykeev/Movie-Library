package urmatshabykeev.movielibrary.models.DTOs;

import com.sun.istack.NotNull;
import lombok.Data;
import urmatshabykeev.movielibrary.models.entities.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Data
public class MovieDTO {
    private Long id;
    private String movieName;
    private String movieDescription;
    private Date releaseDate;
    private Director director;
    private Country country;
    private Genre genre;
    private BigDecimal totalSpendings;
    private BigDecimal totalEarnings;
    private FilmStudio filmStudio;
}
