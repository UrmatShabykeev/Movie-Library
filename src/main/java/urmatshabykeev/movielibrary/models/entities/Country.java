package urmatshabykeev.movielibrary.models.entities;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country_name")
    @NotNull
    private String countryName;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private List<Director> directorList;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private List<Actor> actorList;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private List<Writer> writerList;
}
