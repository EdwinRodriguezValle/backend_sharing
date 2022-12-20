package sharing.com.enjoying.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sharing.com.enjoying.models.RatingAndCommentsModel;

public interface RatingAndCommentsRepository extends JpaRepository <RatingAndCommentsModel, Long> {
}
