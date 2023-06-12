package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.business.rules.EmployerBusinessRules;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.dataAccess.abstracts.EmployerRepository;
import kodlama.io.hrms.entities.concretes.Employer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class EmployerManager implements EmployerService {
	
	@Autowired
	private EmployerRepository employerRepository;
	
	@Autowired
	private EmployerBusinessRules employerBusinessRules;
	
	public Result add(Employer employer ) {
		employerBusinessRules.checkIfNull
		(employer.getCompanyName(), employer.getEmail(),employer.getPassword()
				,employer.getPhoneNumber(),employer.getWebSite());
		employerBusinessRules.checkIfExists(employer.getEmail());
		employerBusinessRules.isEmailVerified(employer);
		employerBusinessRules.isVerifiedbyPersonnel(employer);
		employerRepository.save(employer);	
		return new Result(true,"Employer added to the database");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new DataResult<List<Employer>>(employerRepository.findAll(), true, "All employers are listed!");
	}
	
	
}
