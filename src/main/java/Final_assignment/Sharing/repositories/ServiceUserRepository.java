package Final_assignment.Sharing.repositories;

import Final_assignment.Sharing.models.ServiceUserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceUserRepository extends JpaRepository<ServiceUserModel, Long> {
}
