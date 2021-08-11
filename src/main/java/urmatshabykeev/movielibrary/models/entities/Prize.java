package urmatshabykeev.movielibrary.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "prizes")
public class Prize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nomination_name")
    private String prizeName;

    @OneToMany(mappedBy = "prize", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Nomination> nominations;

}
