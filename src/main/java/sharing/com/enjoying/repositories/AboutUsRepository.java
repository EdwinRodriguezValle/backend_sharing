package sharing.com.enjoying.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sharing.com.enjoying.models.AboutUsModel;

public interface AboutUsRepository  extends JpaRepository <AboutUsModel, Long> {
}
