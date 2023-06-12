package kodlama.io.hrms.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CV;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/api/jobseekers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekersController {
	
	@Autowired
	private JobSeekerService jobSeekerService;
	
	@PostMapping("/add")
	public Result add(JobSeeker jobSeeker) {
		return jobSeekerService.add(jobSeeker);
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll(){
		return jobSeekerService.getAll();
	}
	
	@GetMapping("/getallcvs")
	public DataResult<List<CV>> getAllcvs(@RequestParam int jobSeekerId){
		return jobSeekerService.getAllCvs(jobSeekerId);
	}
}
