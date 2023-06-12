package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WorkExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="workexperience_id")
	private int id;
	
	private String companyName;
	
	private String jobTitle;
	
	private int startingYear;
	
	private int leavingYear;
	
	//private Date experience;
	
	@ManyToOne
	@JoinColumn(name="cv_id")
	private CV cv;
	
//	@ManyToOne
//	@JoinColumn(name="jobseeker_id")
//	private JobSeeker jobseeker;
	
}
