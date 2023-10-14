package idv.wantedpreonboardingbackend.jobopening.service;

import idv.wantedpreonboardingbackend.jobopening.domain.FindAllJobopeningDTO;
import idv.wantedpreonboardingbackend.jobopening.domain.FindAllJobopeningDTOInterface;
import idv.wantedpreonboardingbackend.jobopening.domain.JobopeningEntity;
import idv.wantedpreonboardingbackend.jobopening.domain.UpdateJobopeningDTO;
import idv.wantedpreonboardingbackend.jobopening.repository.JobopeningRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobopeningService {
    @Autowired
    JobopeningRepository jobopeningRepository;

    // 채용공고 등록
    @Transactional
    public JobopeningEntity registerJobopening(JobopeningEntity jobopeningEntity) {
        return jobopeningRepository.save(jobopeningEntity);
    }

    // 채용공고 수정
    @Transactional
    public JobopeningEntity updateJobopening(UpdateJobopeningDTO updateJobopeningDTO, Long id) {
        JobopeningEntity entity = jobopeningRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("ID와 일치하는 채용공고가 없습니다.");
        });

        // 엔티티 수정
        if(updateJobopeningDTO.getRecruitment_position() != null) entity.setRecruitment_position(updateJobopeningDTO.getRecruitment_position());
        if(updateJobopeningDTO.getRecruitment_compensation() != null)entity.setRecruitment_compensation(updateJobopeningDTO.getRecruitment_compensation());
        if(updateJobopeningDTO.getRecruitment_info() != null)entity.setRecruitment_info(updateJobopeningDTO.getRecruitment_info());
        if(updateJobopeningDTO.getTech_in_use() != null)entity.setTech_in_use(updateJobopeningDTO.getTech_in_use());

        // 수정된 엔티티 저장하여 업데이트
        return jobopeningRepository.save(entity);
    }

    // 채용공고 삭제
    @Transactional
    public String deleteJobopening(Long id) {
        JobopeningEntity entity = jobopeningRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("ID와 일치하는 채용공고가 없습니다.");
        });
        jobopeningRepository.delete(entity);
        return "삭제 성공";
    }

    // 채용공고 조회
    public List<FindAllJobopeningDTOInterface> findAllJobopeing() {
        return jobopeningRepository.findAllJobopening();
    }

    // 채용공고 검색

    // 채용공고 상세페이지 조회

    // 채용공고 지원

}
