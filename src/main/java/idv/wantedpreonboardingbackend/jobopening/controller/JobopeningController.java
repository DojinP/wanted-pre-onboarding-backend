package idv.wantedpreonboardingbackend.jobopening.controller;

import idv.wantedpreonboardingbackend.jobopening.domain.JobopeningEntity;
import idv.wantedpreonboardingbackend.custom.Response;
import idv.wantedpreonboardingbackend.jobopening.service.JobopeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobopeningController {
    @Autowired
    JobopeningService jobopeningService;

    // 채용공고 등록
    public Response<?> registerJobopening(@RequestBody JobopeningEntity jobopeningEntity){
        return new Response<>("true", "등록 성공", jobopeningService.registerJobopening(jobopeningEntity));
    }
    // 채용공고 수정

    // 채용공고 삭제

    // 채용공고 조회

    // 채용공고 검색

    // 채용공고 상세페이지 조회

    // 채용공고 지원

}
