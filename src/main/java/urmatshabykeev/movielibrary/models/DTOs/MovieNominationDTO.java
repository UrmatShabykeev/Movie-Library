package urmatshabykeev.movielibrary.models.DTOs;

import lombok.Data;
import urmatshabykeev.movielibrary.models.entities.Movie;
import urmatshabykeev.movielibrary.models.entities.Nomination;

@Data
public class MovieNominationDTO {
    private Long id;
    private Movie movie;
    private Nomination nomination;
    private boolean isAwarded;
}
