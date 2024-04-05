package isthatkirill.expertsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author Kirill Emelyanov
 */

@Getter
@Setter
@Entity
@ToString
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 128)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "job")
    private List<Trust> trusts;

}
