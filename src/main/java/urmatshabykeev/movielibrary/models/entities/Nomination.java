package urmatshabykeev.movielibrary.models.entities;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "nominations")
public class Nomination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nomination_category_name")
    private String nominationName;

    @ManyToOne
    @JoinColumn(name = "prize_id")
    private Prize prize;

    @OneToMany(mappedBy = "nomination")
    private Set<MovieNomination> movieNominations = new HashSet<>();
}
