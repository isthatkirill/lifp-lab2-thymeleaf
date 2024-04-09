package isthatkirill.expertsystem.service;

import isthatkirill.expertsystem.model.Fact;
import isthatkirill.expertsystem.repository.FactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Kirill Emelyanov
 */

@Service
@RequiredArgsConstructor
public class FactService {

    private final FactRepository factRepository;
    private final Scanner scanner = new Scanner(System.in);

    public List<Fact> getFacts() {
        return factRepository.findAll();
    }

    public List<Long> getPositiveFacts() {
        List<Fact> facts = factRepository.findAll();
        List<Long> positiveFacts = new ArrayList<>();

        for (Fact fact : facts) {
            System.out.println(fact.getDescription() + " (y/n)");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                positiveFacts.add(fact.getId());
            }
        }

        return positiveFacts;
    }

}
