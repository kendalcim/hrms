package kodlama.io.hrms.entities.concretes;


import java.util.List;

import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

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
	
	@NotNull
	@javax.persistence.Column(name="company_name")
	private String companyName;
	
	@NotNull
	@javax.persistence.Column(name="website")
	private String webSite;
	
	@NotNull
	@javax.persistence.Column(name="email")
	@Email
	private String email;
	
	@NotNull
	@javax.persistence.Column(name="phone_number")
	private String phoneNumber;
	
	@NotNull
	@javax.persistence.Column(name="password")
	private String password;
	
	@NotNull
	@javax.persistence.Column(name="retype_password")
	private String reTypePassword;
	
	@NotNull
	@javax.persistence.Column(name="is_activated")
	private boolean isActivated;
	
	@OneToMany(mappedBy = "employer")
	private List<JobAd> jobAds;
	
}
