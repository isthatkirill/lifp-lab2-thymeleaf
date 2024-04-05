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
@ToString(exclude = "job")
@Entity
@Table(name = "trust")
public class Trust {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fact_id", nullable = false)
    private Fact fact;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @Column(nullable = false)
    private Double trustCf;

}
