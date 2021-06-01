package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	Result add(JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisement>> getAll();
	
	DataResult<List<JobAdvertisement>> getAllIsActiveJobAdvertisement();
	
	DataResult<List<JobAdvertisement>> findActiveAdvByAdvertisementDeadline();
	DataResult<List<JobAdvertisement>> getByIsActiveAndId( int employerId);
	
	
	DataResult<List<JobAdvertisement>>  findActiveAdvByCreationDate();
	
	Result changeActiveToPasive(int id);
	Result update(JobAdvertisement jobAdvertisement);
	DataResult<JobAdvertisement> getById(int id);	
}
