package kodlama.io.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="JobAds")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAd {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="jobad_id")
	private int id;
	
	@NotNull
	@Column(name="job_description")
	private String jobDescription;
	
	@NotNull
	@Column(name="position_name")
	private String jobPositionName;
	
	@NotNull
	@Column(name="job_city")
	private String jobCity;
	
	@Column(name="minimum_salary")
	private long minimumSalary;
	
	@Column(name="maximum_salary")
	private long maximumSalary;
	
	@NotNull
	@Column(name="number_of_positions")
	private int amountToHire;
	
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME)
	@Column(name="last_date_toapply")
	private Date lastDateToApply;
	
	@ManyToOne
	@JoinColumn(name = "employer_id")
	@JsonIgnore
	private Employer employer;
	
	@Column(name="is_active")
	private boolean isActive;
}
