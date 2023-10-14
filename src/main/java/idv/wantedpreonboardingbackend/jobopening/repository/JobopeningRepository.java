package idv.wantedpreonboardingbackend.jobopening.repository;

import idv.wantedpreonboardingbackend.jobopening.domain.FindAllJobopeningDTO;
import idv.wantedpreonboardingbackend.jobopening.domain.FindAllJobopeningDTOInterface;
import idv.wantedpreonboardingbackend.jobopening.domain.JobopeningEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobopeningRepository extends JpaRepository<JobopeningEntity, Long> {
    @Query(
            nativeQuery = true,
            value = "select j.id as id, c.name as company_name, c.nation as nation, c.region as region, j.recruitment_position as recruitment_position, " +
                    "j.recruitment_compensation as recruitment_compensation, j.tech_in_use as tech_in_use " +
                    "from jobopening j " +
                    "inner join company c " +
                    "on j.company_id = c.id "
    )
    List<FindAllJobopeningDTOInterface> findAllJobopening();
}
