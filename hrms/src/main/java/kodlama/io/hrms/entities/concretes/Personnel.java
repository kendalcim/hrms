package kodlama.io.hrms.entities.concretes;


import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@javax.persistence.Table(name="Personnel")
@Data
@AllArgsConstructor
@NoArgsConstructor
@javax.persistence.Entity
public class Personnel {

	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
	@javax.persistence.Column(name="personnel_id")
	private int Id;
	
	@javax.persistence.Column(name="first_name")
	private String firstName;
	
	@javax.persistence.Column(name="last_name")
	private String lastName;
	
}
