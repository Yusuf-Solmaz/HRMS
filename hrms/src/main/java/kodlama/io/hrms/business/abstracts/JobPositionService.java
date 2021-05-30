package kodlama.io.hrms.business.abstracts;

import java.util.List; 

import org.springframework.stereotype.Component;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.JobPosition;



@Component
public interface JobPositionService {

	List<JobPosition> getAll(); 
	
	DataResult<JobPosition> add(JobPosition jobPosition);
}