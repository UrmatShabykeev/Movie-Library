package urmatshabykeev.movielibrary.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import urmatshabykeev.movielibrary.models.entities.FilmStudio;

@Repository
public interface FilmStudioRepository extends JpaRepository<FilmStudio, Long> {
}
