package urmatshabykeev.movielibrary.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "movie_nominations")
public class MovieNomination implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nomination_id")
    private Nomination nomination;

    @Column(name = "is_awarded")
    private boolean isAwarded;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieNomination)) return false;
        MovieNomination that = (MovieNomination) o;
        return Objects.equals(movie.getMovieName(), that.movie.getMovieName()) &&
                Objects.equals(nomination.getNominationName(), that.nomination.getNominationName()) &&
                Objects.equals(isAwarded, that.isAwarded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie.getMovieName(), nomination.getNominationName(), isAwarded);
    }
}
