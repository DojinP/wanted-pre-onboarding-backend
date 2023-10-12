package idv.wantedpreonboardingbackend.jobopening.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "JOBOPENING")
public class JobopeningEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyId;   // 회사 id
    private String recruitmentPosition; // 채용 포지션
    private Long recruitmentCompensation;    // 채용 보상금
    private String recruitmentInfo; // 채용내용
    private String techInUse;   // 사용 기술


}
