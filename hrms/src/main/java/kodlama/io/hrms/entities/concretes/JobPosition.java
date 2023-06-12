package kodlama.io.hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@javax.persistence.Table(name="JobPositions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@javax.persistence.Entity
public class JobPosition {
	
	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@javax.persistence.Column(name="jobposition_id")
	private int id;

	@javax.persistence.Column(name="position_name")
	private String positionName;
	
//	@OneToMany(mappedBy = "jobPosition")
//	private List<JobAd> jobAds;
}
