package sharing.com.enjoying.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sharing.com.enjoying.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, String> {
}
