package idv.wantedpreonboardingbackend.jobopening.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name = "APPLY_JOBOPENING")
public class ApplyJobopeningEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long jobopeningId;
    Long userId;
}
