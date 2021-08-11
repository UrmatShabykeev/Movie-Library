package urmatshabykeev.movielibrary.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import urmatshabykeev.movielibrary.models.entities.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
}
