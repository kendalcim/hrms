package kodlama.io.hrms.entities.concretes;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CV {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cv_id")
	private int id;
	
	@OneToMany(mappedBy = "cv")
	private List<EducationalInstitution> educationalInstitutions;
	
	@OneToMany(mappedBy = "cv")
	private List<WorkExperience> workExperience;
	
//	private HashMap<String, Integer> foreignLanguagesAndLevels;
	
	private String photoUrl;
	
	private String linkedInUrl;
	
	private ArrayList<String> proficientProgrammingLanguagesAndTech;
	
	private String coverLetter;
	
	@ManyToOne
	@JoinColumn(name="jobseeker_id")
	private JobSeeker jobSeeker;
	

	
	
}
