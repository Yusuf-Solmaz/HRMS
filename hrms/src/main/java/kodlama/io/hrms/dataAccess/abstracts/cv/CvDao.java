package kodlama.io.hrms.dataAccess.abstracts.cv;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.JobSeeker;
import kodlama.io.hrms.entities.concretes.cv.Cv;


public interface CvDao extends  JpaRepository<Cv, Integer>{

	
	List<Cv> getByJobSeekerId(int jobSeekerId);
	
	boolean existsById(int id);
	
	Cv findById(int id);
	
	Cv getByJobSeeker(JobSeeker jobSeeker);
}
