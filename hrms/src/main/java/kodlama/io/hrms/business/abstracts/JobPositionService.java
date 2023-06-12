package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.entities.concretes.JobPosition;


public interface JobPositionService {

	public List<JobPosition> getAll();
	
	public void add(JobPosition jobPosition);
}
