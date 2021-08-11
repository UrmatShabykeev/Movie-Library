package urmatshabykeev.movielibrary.models.entities;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "writers")
@DiscriminatorValue("2")
public class Writer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "writer_name")
    private String writerName;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sex_id")
    private Sex sex;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "date_of_death")
    private Date dateOfDeath;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "total_earnings", precision=10, scale=2)
    private BigDecimal totalEarnings;

    @ManyToMany(mappedBy = "writers")
    Set<Movie> movies;
}
