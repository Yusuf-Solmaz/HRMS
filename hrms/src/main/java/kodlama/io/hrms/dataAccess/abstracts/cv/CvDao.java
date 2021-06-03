package kodlama.io.hrms.dataAccess.abstracts.cv;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.cv.Cv;


public interface CvDao extends  JpaRepository<Cv, Integer>{

	
	List<Cv> getByJobSeeker_Id(int jobSeekerId);
}
