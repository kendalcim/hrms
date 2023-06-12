package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.hrms.entities.concretes.JobSeeker;

@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker, Integer> {
	boolean existsByEmail(String email);
	boolean existsByNationalIdNo(String nationalIdNo);
}
