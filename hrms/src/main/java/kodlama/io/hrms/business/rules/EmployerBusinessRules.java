package kodlama.io.hrms.business.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.dataAccess.abstracts.EmployerRepository;
import kodlama.io.hrms.entities.concretes.Employer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class EmployerBusinessRules {

	@Autowired
	private EmployerRepository employerRepository;

	public void checkIfExists(String email) {
		if (employerRepository.existsByEmail(email)) {
			throw new RuntimeException("Email already exists in the database");
		}
	}

	public void checkIfNull(String... inputs) {
		for (String input : inputs) {
			if (input == null || input.trim().length() == 0) {
				throw new RuntimeException("All fields must be filled!");
			}
		}

	}

	public boolean isEmailVerified(Employer employer) {
		/*business rules for checking email verification
		throw exception if not*/
		return true;
	}
	
	public boolean isVerifiedbyPersonnel(Employer employer) {
		/*business rules for checking whether employer
		is verified by the system personnel. throw exception if not */
		return true;
	}
}
