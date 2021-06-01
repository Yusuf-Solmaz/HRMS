package kodlama.io.hrms.repository;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.concretes.JobAdvertisement;


public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement, Integer> {



	@Query("From JobAdvertisement where isActive = true")
    List<JobAdvertisement> getAllIsActiveJobAdvertisementList();
	

	List<JobAdvertisement>  findByIsActiveTrueOrderByAdvertisementDeadline(); 
		
	
	List<JobAdvertisement> getByIsActiveAndEmployer_Id(boolean isActive, int employerId);
		
	JobAdvertisement getByJobAdvertisementId(int id);
	
	
}
