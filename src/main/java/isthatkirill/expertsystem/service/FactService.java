package isthatkirill.expertsystem.service;

import isthatkirill.expertsystem.model.Fact;

import java.util.List;
import java.util.Map;

/**
 * @author Kirill Emelyanov
 */

public interface FactService {

    List<Fact> getFacts();

    Fact saveFact(Map<String, String> params);

    void deleteFact(Long factId);

    Fact updateFact(Long factId, Map<String, String> params);

}
