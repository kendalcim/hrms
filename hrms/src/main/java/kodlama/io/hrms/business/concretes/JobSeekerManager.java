package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.business.rules.JobSeekerBusinessRules;
import kodlama.io.hrms.core.utilities.adapters.abstracts.MernisAdapterService;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerRepository;
import kodlama.io.hrms.entities.concretes.CV;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerManager implements JobSeekerService{
	
	
	@Autowired
	private JobSeekerBusinessRules jobSeekerBusinessRules;
	
	@Autowired
	private MernisAdapterService mernisAdapterService;
	
	@Autowired
	private JobSeekerRepository jobSeekerRepository;
	
	public SuccessResult add(JobSeeker jobSeeker) {
		jobSeekerBusinessRules.checkIfNull(jobSeeker.getBirthYear(),jobSeeker.getEmail(),jobSeeker.getFirstName(),
				jobSeeker.getLastName(),jobSeeker.getNationalIdNo(),jobSeeker.getPassword());
		mernisAdapterService.verifyPerson(jobSeeker);
		jobSeekerBusinessRules.checkIfExists(jobSeeker.getEmail(), jobSeeker.getNationalIdNo());
		jobSeekerBusinessRules.sendEmailVerification(jobSeeker);
		jobSeekerRepository.save(jobSeeker);
		return new SuccessResult("Jobseeker saved to the database");
	}
	
	public SuccessDataResult<List<JobSeeker>>  getAll(){
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerRepository.findAll(),"Data listed");
	}
	
	public SuccessDataResult<List<CV>> getAllCvs(int jobSeekerId){
		    Optional<JobSeeker> optionalJobSeeker = jobSeekerRepository.findById(jobSeekerId);
		    JobSeeker searchedJobSeeker = optionalJobSeeker.orElseThrow(()
		    		->new IllegalArgumentException("Searched id does not exists" + jobSeekerId));
		return new SuccessDataResult<List<CV>>(searchedJobSeeker.getCvList(),"Searched cvs of" + searchedJobSeeker.getFirstName()+"listed");
	}

}
