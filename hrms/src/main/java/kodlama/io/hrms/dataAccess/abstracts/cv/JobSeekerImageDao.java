package kodlama.io.hrms.dataAccess.abstracts.cv;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.JobSeekerImage;

public interface JobSeekerImageDao extends  JpaRepository<JobSeekerImage,Integer>{

	 List<JobSeekerImage> getAllByJobSeekerId(int jobSeekerId);
}
