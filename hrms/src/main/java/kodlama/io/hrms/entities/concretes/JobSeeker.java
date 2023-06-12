package kodlama.io.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@javax.persistence.Table(name = "JobSeekers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@javax.persistence.Entity
public class JobSeeker {
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name="jobseeker_id")
	private int id;
	
	@NotNull
	@Column(name="first_name")
	private String firstName;
	
	@NotNull
	@Column(name="last_name")
	private String lastName;
	
	@NotNull
	@Column(name="email")
	private String email;
	
	@NotNull
	@Column(name="birthyear")
	private String birthYear;
	
	@javax.validation.constraints.NotNull
	@Column(name="password")
	private String password;
	
	@javax.validation.constraints.NotNull
	@Column(name="retype_password")
	private String reTypePassword;
	
	@NotNull
	@Column(name="national_id")
	private String nationalIdNo;
	
	@NotNull
	@Column(name="is_activated")
	private boolean isActivated;
	
	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore
	private List<CV> cvList;
//	
	

}
