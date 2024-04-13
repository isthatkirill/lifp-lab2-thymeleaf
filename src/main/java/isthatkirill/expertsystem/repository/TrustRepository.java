package isthatkirill.expertsystem.repository;

import isthatkirill.expertsystem.model.Trust;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kirill Emelyanov
 */

@Repository
public interface TrustRepository extends JpaRepository<Trust, Long> {
}
