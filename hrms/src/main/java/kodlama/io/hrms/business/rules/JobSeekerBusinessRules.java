package kodlama.io.hrms.business.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.dataAccess.abstracts.JobSeekerRepository;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class JobSeekerBusinessRules {
	
	@Autowired
	private JobSeekerRepository jobSeekerRepository;
	
//	@Autowired
//	private ConfirmationToken confirmationToken;
//	
//	@Autowired
//	private EmailService emailService;
//	
//	@Autowired
	//private ConfirmationTokenManager confirmationTokenManager;
	
	//is it okay to write two attributes into one method ? can split these into two methods.
	public void checkIfExists(String email, String nationalIdNo) {
		if(jobSeekerRepository.existsByEmail(email)|| jobSeekerRepository.existsByNationalIdNo(nationalIdNo)) {
			throw new RuntimeException("The jobseeker already exists in the database");
		}
	}
	
	public void checkIfNull(String... inputs) {
		for (String input : inputs) {		
		if(input==null || input.trim().length()==0) {
			throw new RuntimeException("All fields must be filled!");
		}}}	
	
	public void sendEmailVerification(JobSeeker jobSeeker) {
		return;
//		SimpleMailMessage emailMessage = new SimpleMailMessage();
//		emailMessage.setTo(jobSeeker.getEmail());
//		emailMessage.setSubject("Complete Registration!");
//		emailMessage.setText("To confirm your account, please click here:" + 
//				"http://localhost:8080/confirm-account?token=" + confirmationTokenManager.generateJobSeekerconfirmatToken(jobSeeker)
//				);
//		emailService.sendEmail(emailMessage);
//		return;
	}
	
	
	}



	

