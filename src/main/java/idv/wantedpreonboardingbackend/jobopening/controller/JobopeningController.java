package idv.wantedpreonboardingbackend.jobopening.controller;

import idv.wantedpreonboardingbackend.jobopening.domain.JobopeningEntity;
import idv.wantedpreonboardingbackend.custom.Response;
import idv.wantedpreonboardingbackend.jobopening.domain.UpdateJobopeningDTO;
import idv.wantedpreonboardingbackend.jobopening.service.JobopeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobopening")
public class JobopeningController {
    @Autowired
    JobopeningService jobopeningService;

    // 채용공고 등록
    @PostMapping()
    public Response<?> registerJobopening(@RequestBody JobopeningEntity jobopeningEntity){
        System.out.println("요청 확인!");
        System.out.println(jobopeningEntity);
        return new Response<>("true", "등록 성공", jobopeningService.registerJobopening(jobopeningEntity));
    }
    // 채용공고 수정
    @PatchMapping("/{id}")
    public Response<?> updateJobopening(@RequestBody UpdateJobopeningDTO updateJobopeningDTO, @PathVariable Long id){
        return new Response<>("true", "수정 성공", jobopeningService.updateJobopening(updateJobopeningDTO, id));
    }

    // 채용공고 삭제
    @DeleteMapping("/{id}")
    public Response<?> deleteJobopening(@PathVariable Long id){
        return new Response<>("true", jobopeningService.deleteJobopening(id), null);
    }

    // 채용공고 조회

    // 채용공고 검색

    // 채용공고 상세페이지 조회

    // 채용공고 지원

}
