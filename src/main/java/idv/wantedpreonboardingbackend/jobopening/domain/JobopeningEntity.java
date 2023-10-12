package idv.wantedpreonboardingbackend.jobopening.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "JOBOPENING")
public class JobopeningEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private Long company_id;   // 회사 id
    @NonNull
    private String recruitment_position; // 채용 포지션
    @NonNull
    private Long recruitment_compensation;    // 채용 보상금
    @NonNull
    private String recruitment_info; // 채용 내용
    @NonNull
    private String tech_in_use;   // 사용 기술

}
