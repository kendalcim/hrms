package kodlama.io.hrms.business.concretes;

import java.util.Optional;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.dataAccess.abstracts.JobSeekerRepository;
import kodlama.io.hrms.entities.concretes.ConfirmationToken;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class ConfirmationTokenManager {
	
	private ConfirmationToken confirmationToken;
	
	private JobSeeker jobSeeker;
	
	private JobSeekerRepository jobSeekerRepository;
	
	public String generateJobSeekerconfirmatToken(JobSeeker jobseeker) {
		confirmationToken.setTokenCode((jobseeker.getBirthYear()) + (jobseeker.getId() * 17));
		return confirmationToken.getTokenCode();
}
	
	public Optional<JobSeeker> detectJobSeekerbyConfirmationToken(String confirmationTokenCode) {
		int jobSeekerId = (Integer.parseInt(confirmationTokenCode.substring(4)))/17;
		return jobSeekerRepository.findById(jobSeekerId);
	}
}
