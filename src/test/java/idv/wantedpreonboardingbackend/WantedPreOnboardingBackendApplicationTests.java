package idv.wantedpreonboardingbackend;

import idv.wantedpreonboardingbackend.custom.Response;
import idv.wantedpreonboardingbackend.jobopening.domain.JobopeningEntity;
import idv.wantedpreonboardingbackend.jobopening.domain.UpdateJobopeningDTO;
import idv.wantedpreonboardingbackend.jobopening.repository.JobopeningRepository;
import idv.wantedpreonboardingbackend.jobopening.service.JobopeningService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WantedPreOnboardingBackendApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	JobopeningService jobopeningService;
	@Autowired
	JobopeningRepository jobopeningRepository;

	@Test
	void register() {

		// given
		Long company_id = 1L;
		String recruitment_position = "풀스택 개발자";
		Long recruitment_compensation = 200000000L;
		String recruitment_info = "10년 경력 이상";
		String tech_in_use = "Java, Spring, Spring Boot, Spring Security";

		JobopeningEntity jobopeningEntity = new JobopeningEntity(
				company_id,
				recruitment_position,
				recruitment_compensation,
				recruitment_info,
				tech_in_use
		);

		String url = "http://localhost:" + port + "/preonboarding/jobopening";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<JobopeningEntity> request = new HttpEntity<>(jobopeningEntity, headers);

		// when
		ResponseEntity<Response<JobopeningEntity>> response = restTemplate.exchange(
				url,
				HttpMethod.POST,
				request,
				new ParameterizedTypeReference<Response<JobopeningEntity>>() {}
		);

		// then
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getSuccess()).isEqualTo("true");

		/*		List<JobopeningEntity> list = jobopeningRepository.findAll();

		assertThat(list.get(id).getCompany_id()).isEqualTo(company_id);
		assertThat(list.get(id).getRecruitment_position()).isEqualTo(recruitment_position);
		assertThat(list.get(id).getRecruitment_compensation()).isEqualTo(recruitment_compensation);
		assertThat(list.get(id).getRecruitment_info()).isEqualTo(recruitment_info);
		assertThat(list.get(id).getTech_in_use()).isEqualTo(tech_in_use);*/

	}

	@Test
	void update() {

		// given
		Long id = 8L;
		String recruitment_position = "세무회계 전문가";
		Long recruitment_compensation = 13000000L;
		String recruitment_info = "세무회계 전문가를 모집합니다.";
		String tech_in_use = "세무, 회계";

		UpdateJobopeningDTO updateJobopeningDTO = new UpdateJobopeningDTO(
				null,
				recruitment_compensation,
				null,
				null
		);

		String url = "http://localhost:" + port + "/preonboarding/jobopening/" + id;

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<UpdateJobopeningDTO> request = new HttpEntity<>(updateJobopeningDTO, headers);

		// PATCH 메소드 사용을 위한 코드
		restTemplate.getRestTemplate().setRequestFactory(new HttpComponentsClientHttpRequestFactory());

		// when
		ResponseEntity<Response<JobopeningEntity>> response = restTemplate.exchange(
				url,
				HttpMethod.PATCH,
				request,
				new ParameterizedTypeReference<Response<JobopeningEntity>>() {}
		);

		// then
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getSuccess()).isEqualTo("true");

		//jobopeningService.updateJobopening(updateJobopeningDTO, id);
	}

	@Test
	void delete() {

		// given
		Long id = 8L;

		String url = "http://localhost:" + port + "/preonboarding/jobopening/" + id;

		// when
//		ResponseEntity<Response<JobopeningEntity>> response = restTemplate.delete(url);

		// then
//		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//		assertThat(response.getBody().getSuccess()).isEqualTo("true");

		//jobopeningService.updateJobopening(updateJobopeningDTO, id);
	}

}
