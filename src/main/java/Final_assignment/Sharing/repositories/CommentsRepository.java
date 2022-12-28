package Final_assignment.Sharing.repositories;

import Final_assignment.Sharing.models.CommentsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<CommentsModel, Long> {
}
