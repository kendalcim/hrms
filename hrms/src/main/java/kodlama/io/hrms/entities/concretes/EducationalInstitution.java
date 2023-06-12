package kodlama.io.hrms.entities.concretes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EducationalInstitution{
	
	@Id
	private int id;
	
	@NotNull
	private String institutionName;
	
	@NotNull
	private int startingYear;
	
	private int graduationYear;
	
	
	private String majoredIn;
	
	@ManyToOne
	@JoinColumn(name="cv_id")
	private CV cv;
	
	
}
