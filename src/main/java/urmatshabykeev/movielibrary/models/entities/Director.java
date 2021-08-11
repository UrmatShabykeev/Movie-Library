package urmatshabykeev.movielibrary.models.entities;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "directors")
@DiscriminatorValue("1")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "director_name")
    private String directorName;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sex_id")
    private Sex sex;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "date_of_death")
    private Date dateOfDeath;

    @ManyToOne
    //@ToString.Exclude
    @JoinColumn(name = "country_id")
    private Country country;



    @Column(name = "total_earnings", precision=10, scale=2)
    private BigDecimal totalEarnings;

    @OneToMany(mappedBy = "director",fetch = FetchType.LAZY)
    private List<Movie> movies;
}
