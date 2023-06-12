package kodlama.io.hrms.entities.concretes;


import java.util.List;

import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@javax.persistence.Table(name="Employers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@javax.persistence.Entity
public class Employer {
	
	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@javax.persistence.Column(name="employer_id")
	private int id;
	
	@javax.validation.constraints.NotNull
	@javax.persistence.Column(name="company_name")
	private String companyName;
	
	@javax.validation.constraints.NotNull
	@javax.persistence.Column(name="website")
	private String webSite;
	
	@javax.validation.constraints.NotNull
	@javax.persistence.Column(name="email")
	private String email;
	
	@javax.validation.constraints.NotNull
	@javax.persistence.Column(name="phone_number")
	private String phoneNumber;
	
	@javax.validation.constraints.NotNull
	@javax.persistence.Column(name="password")
	private String password;
	
	@javax.validation.constraints.NotNull
	@javax.persistence.Column(name="retype_password")
	private String reTypePassword;
	
	@javax.validation.constraints.NotNull
	@javax.persistence.Column(name="is_activated")
	private boolean isActivated;
	
	@OneToMany(mappedBy = "employer")
	private List<JobAd> jobAds;
	
}
