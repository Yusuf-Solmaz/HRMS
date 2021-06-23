package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import kodlama.io.hrms.entities.dtos.JobPostingAddDto;

public interface JobAdvertisementService {

	Result add(JobPostingAddDto jobPostingAddDto);
	Result update(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> getAllIsActiveJobAdvertisement();
	DataResult<List<JobAdvertisement>> getAllIsPasiveJobAdvertisement();
	DataResult<List<JobAdvertisement>> findActiveAdvByAdvertisementDeadline();
	DataResult<List<JobAdvertisement>> getByIsActiveAndId( int employerId);
	
	
	DataResult<List<JobAdvertisement>>  findActiveAdvByCreationDate();
	
	Result changeActiveToPasive(int id);
	Result changePasiveToActive(int id);
	DataResult<JobAdvertisement> getById(int id);	
	DataResult<List<JobAdvertisement>>  findByIsActiveTrueOrderByAdvertisementsDeadline();
	DataResult<List<JobAdvertisement>>  findByIsActiveFalseOrderByAdvertisementsDeadline();
	DataResult<List<JobAdvertisement>> getByIsOpenAndId( int employerId);
}
