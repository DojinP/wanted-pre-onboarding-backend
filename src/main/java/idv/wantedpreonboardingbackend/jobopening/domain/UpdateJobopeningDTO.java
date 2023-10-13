package idv.wantedpreonboardingbackend.jobopening.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateJobopeningDTO {
    private String recruitment_position; // 채용 포지션
    private Long recruitment_compensation;    // 채용 보상금
    private String recruitment_info; // 채용 내용
    private String tech_in_use;   // 사용 기술
}
