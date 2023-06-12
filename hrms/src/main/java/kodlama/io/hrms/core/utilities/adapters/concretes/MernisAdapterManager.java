package kodlama.io.hrms.core.utilities.adapters.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.utilities.adapters.abstracts.MernisAdapterService;
import lombok.Data;

@Service
@Data
public class MernisAdapterManager implements MernisAdapterService {

	@Override
	public boolean verifyPerson(Object obj) {
		// business rules for connecting to Mernis. 
		return true;
	}

}
