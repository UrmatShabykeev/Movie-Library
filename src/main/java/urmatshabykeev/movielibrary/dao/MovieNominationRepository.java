package urmatshabykeev.movielibrary.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import urmatshabykeev.movielibrary.models.entities.MovieNomination;

@Repository
public interface MovieNominationRepository extends JpaRepository<MovieNomination, Long> {
}
