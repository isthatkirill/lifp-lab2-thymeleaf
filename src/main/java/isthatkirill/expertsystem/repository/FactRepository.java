package isthatkirill.expertsystem.repository;

import isthatkirill.expertsystem.model.Fact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kirill Emelyanov
 */

@Repository
public interface FactRepository extends JpaRepository<Fact, Long> {

}
