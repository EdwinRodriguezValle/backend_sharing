package Final_assignment.Sharing.repositories;

import Final_assignment.Sharing.models.ServiceProviderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceProviderRepository extends JpaRepository<ServiceProviderModel, Long> {
}
