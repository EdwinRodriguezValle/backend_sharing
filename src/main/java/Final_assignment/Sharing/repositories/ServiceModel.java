package Final_assignment.Sharing.repositories;

import Final_assignment.Sharing.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceModel extends JpaRepository<UserModel, String> {
}
