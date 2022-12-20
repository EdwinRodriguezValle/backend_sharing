package sharing.com.enjoying.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sharing.com.enjoying.models.UserProfileModel;

import java.util.List;

public interface UserProfileRepository extends JpaRepository <UserProfileModel, Long> {

}
