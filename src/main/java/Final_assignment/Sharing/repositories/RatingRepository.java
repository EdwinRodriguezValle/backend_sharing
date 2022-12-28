package Final_assignment.Sharing.repositories;

import Final_assignment.Sharing.models.RatingModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<RatingModel, Long> {
}
