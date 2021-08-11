package urmatshabykeev.movielibrary.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "film_studios")
public class FilmStudio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "film_studio_name")
    private String filmStudioName;

    @OneToMany(mappedBy = "genre",fetch = FetchType.LAZY)
    private List<Movie> movies;
}
