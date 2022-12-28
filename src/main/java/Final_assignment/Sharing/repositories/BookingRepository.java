package Final_assignment.Sharing.repositories;

import Final_assignment.Sharing.models.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingModel, Long> {
}
