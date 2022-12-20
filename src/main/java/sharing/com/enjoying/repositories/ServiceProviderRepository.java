package sharing.com.enjoying.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sharing.com.enjoying.models.ServiceProviderModel;

public interface ServiceProviderRepository extends JpaRepository <ServiceProviderModel, Long> {
}
