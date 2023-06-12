package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.JobAd;

public interface JobAdService {
	
	public void add(JobAd jobAd);

	public List<JobAd> listActiveAds();

	public SuccessDataResult<List<JobAd>> listActiveAdsByDate();
	
	public SuccessDataResult<List<JobAd>> listActiveAdsByEmployer(int employerId);

	public SuccessResult deactivateJobAd(int jobAdId);
	
	public SuccessDataResult<List<JobAd>> findByJobPositionNameAndIsActiveTrue(String jobPositionName);

	public SuccessDataResult<List<JobAd>> findByJobPositionName(String positionName);
	
	public SuccessDataResult<List<JobAd>> findall();

	public SuccessResult activateAd(int adId);

	public SuccessResult deleteByAdId(int adId);
	
	public DataResult<List<JobAd>> getAllByPage(int pageNo, int pageSize);
}
