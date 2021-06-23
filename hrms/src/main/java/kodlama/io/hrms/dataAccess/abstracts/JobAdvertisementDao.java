package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import kodlama.io.hrms.repository.JobAdvertisementRepository;

public interface JobAdvertisementDao extends JobAdvertisementRepository {

	@Query("From JobAdvertisement where isActive = true")
    List<JobAdvertisement> getAllIsActiveJobAdvertisementList();
	
	@Query("From JobAdvertisement where isActive = false")
	List<JobAdvertisement> getAllPasiveJobAdvertisementList();
	
	List<JobAdvertisement>  findByIsActiveTrueOrderByAdvertisementDeadline(); 
		
	List<JobAdvertisement>  findByIsActiveTrueOrderByCreationDate();
	
	List<JobAdvertisement> getByIsActiveAndEmployer_Id(boolean isActive, int employerId);
		
	JobAdvertisement getByJobAdvertisementId(int id);
	
	List<JobAdvertisement>  findByIsActiveFalseOrderByAdvertisementDeadline();
}
