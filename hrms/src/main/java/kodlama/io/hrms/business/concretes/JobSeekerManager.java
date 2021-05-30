package kodlama.io.hrms.business.concretes;

import java.util.List;   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlama.io.hrms.business.abstracts.JobSeekerService;


import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import lombok.Data;





@Service
@Data

public class JobSeekerManager implements JobSeekerService{

	private JobSeekerDao jobSeekerDao;
	private JobSeekerAuthManager JobSeekerAuthManager;
	
	
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, JobSeekerAuthManager jobSeekerAuthManager) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		JobSeekerAuthManager = jobSeekerAuthManager;
		
	}
	
	
	@Override
	public DataResult<JobSeeker> add(JobSeeker jobSeeker , String restartPassword  ) {
		
		if(!JobSeekerAuthManager.checkFirstName(jobSeeker)) {
			return new ErrorDataResult<JobSeeker>("Ad boş bırakılamaz.");
		}
		else if(!JobSeekerAuthManager.checkLastName(jobSeeker)) {
			return new ErrorDataResult<JobSeeker>("Soyad boş bırakılamaz.");
		}
		else if(!JobSeekerAuthManager.checkBirthDate(jobSeeker)) {
			return new ErrorDataResult<JobSeeker>("Doğum tarihi boş bırakılamaz.");
		}
		
		else if(!JobSeekerAuthManager.checkRestartPassword(restartPassword, jobSeeker)) {
			return new ErrorDataResult<JobSeeker>("Şifre veya şifre tekrarı boş bırakılamaz.");
		}
		else if(!JobSeekerAuthManager.checkIdNumber(jobSeeker.getNationalityId())) {
			
			return new ErrorDataResult<JobSeeker>("Id yanlış");
		}
		else if(!JobSeekerAuthManager.checkEmail(jobSeeker.getMail())) {
			
			return new ErrorDataResult<JobSeeker>("Geçersiz email.");
		}
		else if(!JobSeekerAuthManager.checkRestartPassword(restartPassword, jobSeeker)) {
			
			return new ErrorDataResult<JobSeeker>("Şifreler uyuşmuyor.");
		}
	
		
		else {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.save(jobSeeker),"İş arayan hesabı eklendi . Doğrulandı.");
		}

	}
	@Override
	public DataResult<List<JobSeeker>> getAll() {
		
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "İş arayanlar listelendi.");
		
	}
	
	


	
}
