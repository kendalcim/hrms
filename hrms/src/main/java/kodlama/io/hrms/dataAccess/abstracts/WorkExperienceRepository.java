package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.hrms.entities.concretes.WorkExperience;

@Repository
public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Integer>{
	public List<WorkExperience> findAllByCv_JobSeekerIdOrderByLeavingYearDesc(int jobSeekerId);
}
