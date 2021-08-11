package urmatshabykeev.movielibrary.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import urmatshabykeev.movielibrary.models.entities.Writer;

@Repository
public interface WriterRepository extends JpaRepository<Writer, Long> {
}
