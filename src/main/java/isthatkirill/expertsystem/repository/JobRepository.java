package isthatkirill.expertsystem.repository;

import isthatkirill.expertsystem.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Kirill Emelyanov
 */

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    Optional<Job> findByName(String name);

    List<Job> findAllByOrderByIdAsc();

}
