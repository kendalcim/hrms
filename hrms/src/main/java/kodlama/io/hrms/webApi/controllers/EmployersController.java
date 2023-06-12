package kodlama.io.hrms.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
	
	@Autowired
	private EmployerService employerService;
	
	@PostMapping("/add")
	public kodlama.io.hrms.core.utilities.results.Result add(Employer employer) {
		return employerService.add(employer);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll(){
		return employerService.getAll();
	}
	
}
