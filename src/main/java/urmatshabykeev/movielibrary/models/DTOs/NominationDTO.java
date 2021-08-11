package urmatshabykeev.movielibrary.models.DTOs;

import lombok.Data;
import urmatshabykeev.movielibrary.models.entities.Prize;

@Data
public class NominationDTO {
    private Long id;
    private String nominationName;
    private Prize prize;
}
