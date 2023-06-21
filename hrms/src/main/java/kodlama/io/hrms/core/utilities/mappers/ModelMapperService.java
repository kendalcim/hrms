package kodlama.io.hrms.core.utilities.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {

	
	ModelMapper forResponses();
	ModelMapper forRequests();
	
}
