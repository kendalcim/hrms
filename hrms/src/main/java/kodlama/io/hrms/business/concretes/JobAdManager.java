package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobAdService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployerRepository;
import kodlama.io.hrms.dataAccess.abstracts.JobAdRepository;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.JobAd;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdManager implements JobAdService {
	
	@Autowired
	private JobAdRepository jobAdRepository;
	
	@Autowired
	private EmployerRepository employerRepository;
	
	@Override
	public void add(JobAd jobAd) {
		jobAdRepository.save(jobAd);
	}
	@Override
	public List<JobAd> listActiveAds() {
		return jobAdRepository.findByIsActiveTrue();
	}

	@Override
	public SuccessDataResult<List<JobAd>>listActiveAdsByDate() {
		return new SuccessDataResult<List<JobAd>>(jobAdRepository.findByIsActiveTrueOrderByLastDateToApply(),
				"Ads are listed by the last date to apply!");
	}

	@Override
	public SuccessDataResult<List<JobAd>> listActiveAdsByEmployer(int employerId) {
	Employer employer =	employerRepository.findById(employerId).orElseThrow();

		return new SuccessDataResult<List<JobAd>>(jobAdRepository.findByIsActiveTrueAndEmployerId(employerId),
				"Active ads by the " + employer.getCompanyName() +"listed");
	}
	

	@Override
	public SuccessResult deactivateJobAd(int jobAdId) {
		Optional<JobAd> optionalJobAd = jobAdRepository.findById(jobAdId);
		if(optionalJobAd.isEmpty()) {
			throw new RuntimeException("The ad could not be found");}
		
		JobAd activeAd = optionalJobAd.get();
		activeAd.setActive(false);	
		jobAdRepository.save(activeAd);
		return new SuccessResult("Ad deactivated!");
	}

	@Override
	public SuccessDataResult<List<JobAd>> findByJobPositionNameAndIsActiveTrue(String jobPositionName) {
		List<JobAd> results = jobAdRepository.findByJobPositionNameAndIsActiveTrue(jobPositionName);
		return new SuccessDataResult<List<JobAd>>(results, "Relevant ads listed!");
	}

	@Override
	public SuccessDataResult<List<JobAd>> findByJobPositionName(String positionName) {
		
		return new SuccessDataResult<List<JobAd>>(jobAdRepository.findByJobPositionName(positionName), "Relevant ads listed");
	}
	
	public SuccessDataResult<List<JobAd>> findall(){
		return new SuccessDataResult<List<JobAd>>(jobAdRepository.findAll(), "All ads are listed!");
	}

	@Override
	public SuccessResult activateAd(int adId) {
		Optional<JobAd> potentialResult = jobAdRepository.findById(adId);
		JobAd foundAd = potentialResult.orElseThrow();
		foundAd.setActive(true);
		jobAdRepository.save(foundAd);
		return new SuccessResult("Ad activated");
	}
	@Override
	public SuccessResult deleteByAdId(int adId) {
		jobAdRepository.deleteById(adId);
		return new SuccessResult("Ad deleted!");
	}
	@Override
	public DataResult<List<JobAd>> getAllByPage(int pageNo, int pageSize) {
		PageRequest pageable = PageRequest.of(pageNo-1, pageSize);
		
		return new SuccessDataResult<List<JobAd>>(this.jobAdRepository.findAll(pageable).getContent(), 
				"Ads listed by " + pageSize + "per page");
	}
}
