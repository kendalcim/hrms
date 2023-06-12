package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.hrms.entities.concretes.EducationalInstitution;

@Repository
public interface EducationalInstitutionRepository extends JpaRepository<EducationalInstitution, Integer>{
	public List<EducationalInstitution> findAllByOrderByGraduationYearDesc();
	public List<EducationalInstitution> findAllByCv_JobSeekerIdOrderByGraduationYearDesc(int jobSeekerId);
}
