package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.JobSeeker;

public interface  JobSeekerService {

	DataResult<JobSeeker> add(JobSeeker jobSeeker , String restartPassword);
	
	DataResult<List<JobSeeker>> getAll();
	
	
}
