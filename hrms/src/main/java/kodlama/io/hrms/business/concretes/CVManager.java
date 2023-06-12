package kodlama.io.hrms.business.concretes;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CVService;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.CVRepository;
import kodlama.io.hrms.dataAccess.abstracts.EducationalInstitutionRepository;
import kodlama.io.hrms.dataAccess.abstracts.WorkExperienceRepository;
import kodlama.io.hrms.entities.concretes.CV;
import kodlama.io.hrms.entities.concretes.EducationalInstitution;
import kodlama.io.hrms.entities.concretes.WorkExperience;

@Service
public class CVManager implements CVService {
	
	@Autowired
	private CVRepository cvRepository;
	
	@Autowired
	private EducationalInstitutionRepository educationalInstitutionRepository;
	
	@Autowired
	private WorkExperienceRepository workExperienceRepository;
	
	public  SuccessDataResult<List<EducationalInstitution>> sortedByGraduationYear(CV cv) {
		List<EducationalInstitution> schoolsAttended = cv.getEducationalInstitutions();

	    // Filter institutions with blank graduation year and collect them separately
	    List<EducationalInstitution> institutionsWithBlankYear = schoolsAttended.stream()
	            .filter(s -> s.getGraduationYear() == 0)  // Replace 0 with the appropriate value representing a blank graduation year
	            .collect(Collectors.toList());
	    
	    if(!institutionsWithBlankYear.isEmpty()) {

	    // Remove the institutions with blank graduation year from the original list
	    schoolsAttended.removeAll(institutionsWithBlankYear);

	    // Sort the remaining institutions by graduation year in descending order
	    schoolsAttended.sort(Comparator.comparingInt(EducationalInstitution::getGraduationYear).reversed());

	    // Add the institutions with blank graduation year at the top
	    schoolsAttended.addAll(0, institutionsWithBlankYear);

	    return new SuccessDataResult<List<EducationalInstitution>>(schoolsAttended, "Data listed") ;}
	    
	    return new SuccessDataResult<List<EducationalInstitution>>(educationalInstitutionRepository.findAllByCv_JobSeekerIdOrderByGraduationYearDesc(cv.getJobSeeker().getId()));
	}
	
	
	public SuccessDataResult<List<WorkExperience>> sortByWorkExperience(CV cv) {
		List<WorkExperience> workExperiences = cv.getWorkExperience();
		List<WorkExperience> continuingWorkExperience =workExperiences.stream().filter(s->s.getLeavingYear()==0).collect(Collectors.toList());
		
		if(!continuingWorkExperience.isEmpty()) {
			workExperiences.removeAll(continuingWorkExperience);
			workExperiences.sort(Comparator.comparingInt(WorkExperience::getLeavingYear).reversed());
			workExperiences.addAll(0, continuingWorkExperience);
			return new SuccessDataResult<List<WorkExperience>>(workExperiences, 
					"Past work experiences are sorted by the most recent to oldest.");
		}
		
		return new SuccessDataResult<List<WorkExperience>>(workExperienceRepository.findAllByCv_JobSeekerIdOrderByLeavingYearDesc(cv.getJobSeeker().getId()), 
				"Past work experiences are sorted by the most recent to oldest.");
	}
}
