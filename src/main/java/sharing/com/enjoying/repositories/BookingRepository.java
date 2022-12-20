package sharing.com.enjoying.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sharing.com.enjoying.models.BookingModel;

import java.util.List;

public interface BookingRepository extends JpaRepository<BookingModel, Long > {
    List<BookingModel> findByserviceTypeContaining(String  serviceType);
}
