package Final_assignment.Sharing.repositories;

import Final_assignment.Sharing.models.UserProfileModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfileModel, Long> {
}
