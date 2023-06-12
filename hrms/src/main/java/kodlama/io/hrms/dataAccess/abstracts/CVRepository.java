package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.hrms.entities.concretes.CV;

@Repository
public interface CVRepository extends JpaRepository<CV, Integer> {

}
