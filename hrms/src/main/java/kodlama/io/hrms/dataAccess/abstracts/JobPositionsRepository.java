package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.hrms.entities.concretes.JobPosition;

@Repository
public interface JobPositionsRepository extends JpaRepository<JobPosition, Integer>{
	boolean existsByPositionName(String positionName);
}
