package kodlama.io.hrms.business.concretes;

import java.util.List;     

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobPositionService;
import kodlama.io.hrms.business.auth.abstracts.JobPositionAuthService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;

import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobPositionDao;
import kodlama.io.hrms.entities.concretes.JobPosition;

@Service

public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobDao;
	private JobPositionAuthService jobPositionAuthService;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobDao,JobPositionAuthService jobPositionAuthService) {
		super();
		this.jobDao = jobDao;
		this.jobPositionAuthService=jobPositionAuthService;
	}
	
	
	
	
	
	@Override
	public Result add(JobPosition jobPosition) {
		if(jobPositionAuthService.checkJobPositionName(jobPosition.getJobPosition())) {
			return new ErrorResult("Bu iş pozisyonu zaten kayıtlı.");
		}
		else {
		this.jobDao.save(jobPosition);
		return new SuccessResult("İş pozisyonu eklendi.");
		}
	}
	
	@Override
	public List<JobPosition> getAll() {
		
		return jobDao.findAll();
	}


	
}
