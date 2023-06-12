package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobPositionService;
import kodlama.io.hrms.business.rules.JobPositionBusinessRules;
import kodlama.io.hrms.dataAccess.abstracts.JobPositionsRepository;
import kodlama.io.hrms.entities.concretes.JobPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPositionManager implements JobPositionService {

	@Autowired
	private JobPositionsRepository jobPositionsRepository;
	
	@Autowired
	private JobPositionBusinessRules jobPositionBusinessRules;
	

	@Override
	public List<JobPosition> getAll() {
		
		return jobPositionsRepository.findAll();
	}
	
	public void add(JobPosition jobPosition) {
		jobPositionBusinessRules.checkIfExists(jobPosition.getPositionName());
		jobPositionsRepository.save(jobPosition);
	}
	
}
