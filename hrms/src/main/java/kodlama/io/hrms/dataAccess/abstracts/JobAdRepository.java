package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.hrms.entities.concretes.JobAd;

@Repository
public interface JobAdRepository extends JpaRepository<JobAd, Integer> {
	
	public List<JobAd> findByIsActiveTrue();

	public List<JobAd> findByIsActiveTrueOrderByLastDateToApply();
	
	public List<JobAd> findByIsActiveTrueAndEmployerId(int employerId);
	
	public List<JobAd> findByJobPositionNameAndIsActiveTrue(String jobPositionName);

	public List<JobAd> findByJobPositionName(String positionName);

	public List<JobAd> findByIsActiveTrueOrderByMinimumSalaryDesc();
	
	
}
