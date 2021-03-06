package kodlama.io.hrms.repository;

 

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository; 

import kodlama.io.hrms.entities.concretes.JobPosition;



public interface JobPositionRepository extends JpaRepository<JobPosition, Integer> {

	List<JobPosition> findByJobPosition(String jobPosition);
	
}
