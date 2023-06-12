package kodlama.io.hrms.business.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.dataAccess.abstracts.JobPositionsRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class JobPositionBusinessRules {
	

	
	@Autowired
	private JobPositionsRepository jobPositionsRepository;
	
	public void checkIfExists(String name) {
		if(jobPositionsRepository.existsByPositionName(name)){
			throw new RuntimeException("This job position already exists in the database!");
		};
	}
}
