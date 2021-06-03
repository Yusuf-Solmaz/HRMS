package kodlama.io.hrms.dataAccess.abstracts.cv;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.concretes.cv.CvExperience;


public interface CvExperienceDao  extends  JpaRepository<CvExperience, Integer>{

	@Query("from CvExperience where cv.jobSeeker.id = :id order by leaveDate asc nulls first ")
    List<CvExperience> getAllJobSeekerAndOrderedByAsc(int jobSeekerId);
	
	@Query("from CvExperience where cv.jobSeeker.id = :id order by leaveDate desc nulls first ")
    List<CvExperience> getAllJobSeekerAndOrderedByDesc(int jobSeekerId);
	
	
}
