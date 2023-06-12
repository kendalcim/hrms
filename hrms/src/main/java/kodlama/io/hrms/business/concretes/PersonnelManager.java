package kodlama.io.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.PersonnelService;
import kodlama.io.hrms.dataAccess.abstracts.PersonnelRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonnelManager implements PersonnelService {

	@Autowired
	private PersonnelRepository personnelRepository;
}
