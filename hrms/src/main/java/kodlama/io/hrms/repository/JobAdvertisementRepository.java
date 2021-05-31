package kodlama.io.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository; 

import kodlama.io.hrms.entities.concretes.JobAdvertisement;


public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement, Integer> {

}
