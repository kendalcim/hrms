package kodlama.io.hrms.core.utilities.adapters.concretes;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlama.io.hrms.core.utilities.adapters.abstracts.CloudinaryAdapterService;
import kodlama.io.hrms.dataAccess.abstracts.CVRepository;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerRepository;
import kodlama.io.hrms.entities.concretes.CV;
import kodlama.io.hrms.entities.concretes.JobSeeker;

@Service
public class CloudinaryAdapterManager implements CloudinaryAdapterService {
	
	@Autowired
	private JobSeekerRepository jobSeekerRepository;
	
	@Autowired
	private CVRepository cvRepository;
	
	public void uploadImage(MultipartFile file, int jobSeekerId) throws IOException {
		try {
			Map<String,String> config = new HashMap<>();
			config.put("cloud_name", "de1i1ecxi");
			config.put("api_key", "692154656769522");
			config.put("api_secret", "fuNFL8a3uKFSeZnbRV9HMF95b_c");
			Cloudinary cloudinary = new Cloudinary(config);
			
			String publicId = "jobseeker_" + jobSeekerId; // Append job seeker's ID to the public_id
			
			 Map<String, Object> options = ObjectUtils.asMap("public_id", publicId);
		       Map<?, ?> uploadResult = cloudinary.uploader().upload(file.getBytes(), options);
		   JobSeeker relevantJobSeeker =  jobSeekerRepository.findById(jobSeekerId).orElseThrow(()->
		    new IllegalArgumentException("Jobseeker id could not be found"+jobSeekerId));
		   		
		     String imageUploadUrl  = uploadResult.get("secure_url").toString();
		     List<CV> cvsOfJobSeeker	= relevantJobSeeker.getCvList();
		     cvsOfJobSeeker.forEach(s->s.setPhotoUrl(imageUploadUrl));
		     cvRepository.saveAll(cvsOfJobSeeker);
			
			} catch (IOException exception) {
			  System.out.println(exception.getMessage());
}
	}}		