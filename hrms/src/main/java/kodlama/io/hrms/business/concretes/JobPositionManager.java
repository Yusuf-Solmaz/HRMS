package kodlama.io.hrms.business.concretes;

import java.util.List;    

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobPositionAuthService;
import kodlama.io.hrms.business.abstracts.JobPositionService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
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
	public DataResult<JobPosition> add(JobPosition jobPosition) {
		if(jobPositionAuthService.checkJobPositionName(jobPosition.getJobPosition())) {
			return new ErrorDataResult<JobPosition>("Bu iş pozisyonu zaten kayıtlı.");
		}
		return new SuccessDataResult<JobPosition>(this.jobDao.save(jobPosition),"İş arayan hesabı eklendi . Doğrulandı.");
	}
	
	
	@Override
	public List<JobPosition> getAll() {
		
		return jobDao.findAll();
	}


	
}