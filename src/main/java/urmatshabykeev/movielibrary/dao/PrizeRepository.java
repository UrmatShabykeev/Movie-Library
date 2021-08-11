package urmatshabykeev.movielibrary.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import urmatshabykeev.movielibrary.models.entities.Prize;

@Repository
public interface PrizeRepository extends JpaRepository<Prize, Long> {
}
