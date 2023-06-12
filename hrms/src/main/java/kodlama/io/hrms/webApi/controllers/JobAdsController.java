package kodlama.io.hrms.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobAdService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.JobAd;

@RestController
@RequestMapping("/api/jobads")
public class JobAdsController {

	@Autowired
	private JobAdService jobAdService;
	
	@PostMapping("/add")
	public void add(@RequestBody JobAd jobAd) {
		this.jobAdService.add(jobAd);
	}
	
	@GetMapping("/getactiveads")
	public List<JobAd> listActiveAds(){
		return this.jobAdService.listActiveAds();
	}
	
	@GetMapping("/getactiveadsbylastdatetoapply")
	public SuccessDataResult<List<JobAd>> listActiveAdsByDate(){
		return this.jobAdService.listActiveAdsByDate();
}
	@GetMapping("/getactiveadsbyemployer")
	public SuccessDataResult<List<JobAd>> listActiveAdsByEmployer(int employerId){
		return this.jobAdService.listActiveAdsByEmployer(employerId);
	}
	
	@PutMapping("/deactivatejobad")
	public SuccessResult deactivateJobAd(int jobAdId) {
		return this.jobAdService.deactivateJobAd(jobAdId);
	}
	
	@GetMapping("/searchbyposition")
	public SuccessDataResult<List<JobAd>> findByPositionNameAndIsActiveTrue (@RequestParam String positionName){
		return this.jobAdService.findByJobPositionNameAndIsActiveTrue(positionName);
	}

	
	@GetMapping("/getalladsbyposition")
	public SuccessDataResult<List<JobAd>> findByPositionName(@RequestParam String positionName){
	return this.jobAdService.findByJobPositionName(positionName);}
	
	@GetMapping("/findallads")
	public SuccessDataResult<List<JobAd>> findAll(){
		return this.jobAdService.findall();
	}
	
	@GetMapping("/getalladsbypage")
	public DataResult<List<JobAd>> getAllByPage(@RequestParam int pageNo, @RequestParam int pageSize){
		return this.jobAdService.getAllByPage(pageNo, pageSize);
	}
	
	@PutMapping("/activatead")
	public SuccessResult activateAd(@RequestParam int adId){
		return this.jobAdService.activateAd(adId);
	}
	
	@DeleteMapping("/deletebyid")
	public SuccessResult deleteAdbyId(@RequestParam int adId) {
		return this.jobAdService.deleteByAdId(adId);
	}
	
}
