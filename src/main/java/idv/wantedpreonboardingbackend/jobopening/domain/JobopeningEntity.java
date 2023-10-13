package idv.wantedpreonboardingbackend.jobopening.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "JOBOPENING")
public class JobopeningEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long company_id;   // 회사 id
    private String recruitment_position; // 채용 포지션
    private Long recruitment_compensation;    // 채용 보상금
    private String recruitment_info; // 채용 내용
    private String tech_in_use;   // 사용 기술

    public JobopeningEntity(Long company_id, String recruitment_position, Long recruitment_compensation, String recruitment_info, String tech_in_use) {
        this.company_id = company_id;
        this.recruitment_position = recruitment_position;
        this.recruitment_compensation = recruitment_compensation;
        this.recruitment_info = recruitment_info;
        this.tech_in_use = tech_in_use;
    }
}
