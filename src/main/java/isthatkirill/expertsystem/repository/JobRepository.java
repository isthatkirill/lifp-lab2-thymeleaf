package isthatkirill.expertsystem.repository;

import isthatkirill.expertsystem.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kirill Emelyanov
 */

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}
