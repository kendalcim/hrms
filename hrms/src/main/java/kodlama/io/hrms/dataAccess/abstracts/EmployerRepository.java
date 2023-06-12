package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.hrms.entities.concretes.Employer;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Integer>{

	boolean existsByEmail(String email);
}
