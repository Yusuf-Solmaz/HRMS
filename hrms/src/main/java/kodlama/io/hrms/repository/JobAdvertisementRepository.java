package kodlama.io.hrms.repository;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.concretes.JobAdvertisement;


public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement, Integer> {




	
}
