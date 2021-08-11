package urmatshabykeev.movielibrary.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import urmatshabykeev.movielibrary.models.entities.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
}
