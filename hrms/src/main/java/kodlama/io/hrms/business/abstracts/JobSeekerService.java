package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.CV;
import kodlama.io.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {

	public SuccessDataResult<List<JobSeeker>> getAll();
	
	public SuccessResult add(JobSeeker jobSeeker);
	
	public SuccessDataResult<List<CV>> getAllCvs(int jobSeekerId);
}
