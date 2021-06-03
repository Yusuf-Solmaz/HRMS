package kodlama.io.hrms.dataAccess.abstracts.cv;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.concretes.cv.CvEducation;

public interface CvEducationDao  extends  JpaRepository<CvEducation, Integer>{

	@Query("from CvEducation where cv.jobSeeker.id = :id order by graduationYear asc nulls first ")
    List<CvEducation> getAllJobSeekerAndOrderedByAsc(int jobSeekerId);
	
	@Query("from CvEducation where cv.jobSeeker.id = :id order by graduationYear desc nulls first ")
    List<CvEducation> getAllJobSeekerAndOrderedByDesc(int jobSeekerId);
	
	
	
	
	
	
}
