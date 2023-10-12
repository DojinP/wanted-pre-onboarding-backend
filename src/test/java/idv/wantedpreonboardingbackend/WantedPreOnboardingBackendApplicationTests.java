package idv.wantedpreonboardingbackend;

import idv.wantedpreonboardingbackend.jobopening.domain.JobopeningEntity;
import idv.wantedpreonboardingbackend.jobopening.repository.JobopeningRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WantedPreOnboardingBackendApplicationTests {

	@Autowired
	JobopeningRepository jobopeningRepository;

	@Test
	void save() {

		JobopeningEntity jobopeningEntity = new JobopeningEntity(1L,
												"백엔드 개발자",
												100000000L,
													"10년 경력 환영",
													"Java, Spring");

		jobopeningRepository.save(jobopeningEntity);
	}

}
