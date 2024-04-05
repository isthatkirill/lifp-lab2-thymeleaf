package isthatkirill.expertsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Kirill Emelyanov
 */

@Getter
@Setter
@ToString
@Entity
@Table(name = "facts")
public class Fact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 128)
    private String description;

    @Column(nullable = false)
    private Double weight;

}
