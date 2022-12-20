package sharing.com.enjoying.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sharing.com.enjoying.models.ServiceUserModel;

import java.util.List;

public interface ServiceUserRepository extends JpaRepository <ServiceUserModel, Long> {

}
