package kodlama.io.hrms.business.concretes;

import java.time.LocalDate; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.business.auth.concretes.JobAdvertisementAuthManager;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlama.io.hrms.entities.concretes.City;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import kodlama.io.hrms.entities.concretes.JobPosition;
import kodlama.io.hrms.entities.concretes.TypeOfWorking;
import kodlama.io.hrms.entities.concretes.WayOfWorking;
import kodlama.io.hrms.entities.dtos.JobPostingAddDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{


	private JobAdvertisementDao jobAdvertisementDao;
	private JobAdvertisementAuthManager jobAdvertisementAuthManager;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementAuthManager jobAdvertisementAuthManager,JobAdvertisementDao jobAdvertisementDao) {
		super();
		
		this.jobAdvertisementAuthManager = jobAdvertisementAuthManager;
		this.jobAdvertisementDao=jobAdvertisementDao;
	}

	@Override
	public Result add(JobPostingAddDto jobPostingAddDto) {
		JobAdvertisement jobAdvertisement = new JobAdvertisement(0, jobPostingAddDto.getJobDescription(), jobPostingAddDto.getMinSalary(),
				jobPostingAddDto.getMaxSalary(), jobPostingAddDto.getOpenPositionCount(),
				jobPostingAddDto.getApplicationDeadline(), false, null,
				new Employer(jobPostingAddDto.getEmployerId(), null, null, false, null, null, null, false),
				new JobPosition(jobPostingAddDto.getJobPositionId(), null, null),
				new City(jobPostingAddDto.getCityId(), null, null),
				new TypeOfWorking(jobPostingAddDto.getTypeOfWorkingId(), null, null),
				new WayOfWorking(jobPostingAddDto.getWayOfWorkingId(), null, null));
				
		

		
		
		jobAdvertisement.setActive(false);
		jobAdvertisement.setCreationDate(LocalDate.now());
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.save(jobAdvertisement),"İş ilanı eklendi!");
		
	}


	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll());
	}

	@Override
    public DataResult<List<JobAdvertisement>> getAllIsActiveJobAdvertisement() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllIsActiveJobAdvertisementList());
    }


	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveAndId(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveAndEmployer_Id(true, employerId));
	}

	@Override
	public Result changeActiveToPasive(int id) {
		if (getById(id) == null) {
			return new ErrorResult("Böyle bir iş ilanı bulunamadı.");

		}
		if (getById(id).getData().isActive() == false) {
			return new ErrorResult("");
		}

		JobAdvertisement jobAdvertisement = getById(id).getData();
		jobAdvertisement.setActive(false);
		update(jobAdvertisement);
		return new SuccessResult("İş ilanı kapatıldı.");
	}

	@Override
	public DataResult<JobAdvertisement> getById(int id) {
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getByJobAdvertisementId(id));
	}

	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı güncellendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findActiveAdvByAdvertisementDeadline() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrueOrderByAdvertisementDeadline());
	}

	@Override
	public DataResult<List<JobAdvertisement>> findActiveAdvByCreationDate() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrueOrderByCreationDate());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllIsPasiveJobAdvertisement() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllPasiveJobAdvertisementList());
	}

	@Override
	public Result changePasiveToActive(int id) {
		if (getById(id) == null) {
			return new ErrorResult("There is no such job advertisement");

		}
		if (getById(id).getData().isActive() == true) {
			return new ErrorResult("There job advertisement is already opened.");
		}

		JobAdvertisement jobAdvertisement = getById(id).getData();
		jobAdvertisement.setActive(true);
		update(jobAdvertisement);
		return new SuccessResult("Job advertisement has been successfully closed.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByAdvertisementsDeadline() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrueOrderByAdvertisementDeadline());
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveFalseOrderByAdvertisementsDeadline() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveFalseOrderByAdvertisementDeadline());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsOpenAndId(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveAndEmployer_Id(true, employerId));
	}

	
	
	

}
