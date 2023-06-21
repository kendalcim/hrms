package kodlama.io.hrms.core.utilities.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService {

	
	@Override
	public ModelMapper forResponses() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE).setSkipNullEnabled(true);
				return modelMapper;
	}
	@Override
	public ModelMapper forRequests() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(AccessLevel.PRIVATE).setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STRICT).setSkipNullEnabled(true);
		return modelMapper;
	}


}

