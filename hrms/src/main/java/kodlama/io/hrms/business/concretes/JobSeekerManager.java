package kodlama.io.hrms.business.concretes;

import java.util.List;    

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlama.io.hrms.business.abstracts.JobSeekerService;


import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import lombok.Data;





@Service


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
	public Result add(JobSeeker jobSeeker , String restartPassword  ) {
		
		if(!JobSeekerAuthManager.checkFirstName(jobSeeker)) {
			return new ErrorResult("Ad boş bırakılamaz.");
		}
		else if(!JobSeekerAuthManager.checkLastName(jobSeeker)) {
			return new ErrorResult("Soyad boş bırakılamaz.");
		}
		else if(!JobSeekerAuthManager.checkBirthDate(jobSeeker)) {
			return new ErrorResult("Doğum tarihi boş bırakılamaz.");
		}
		
		else if(!JobSeekerAuthManager.checkRestartPassword(restartPassword, jobSeeker)) {
			return new ErrorResult("Şifre veya şifre tekrarı boş bırakılamaz.");
		}
		else if(!JobSeekerAuthManager.checkIdNumber(jobSeeker.getNationalityId())) {
			
			return new ErrorResult("Id yanlış");
		}
		else if(!JobSeekerAuthManager.checkEmail(jobSeeker.getMail())) {
			
			return new ErrorResult("Geçersiz email.");
		}
		else if(!JobSeekerAuthManager.checkRestartPassword(restartPassword, jobSeeker)) {
			
			return new ErrorResult("Şifreler uyuşmuyor.");
		}
	
		
		else {
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("İş arayan hesabı eklendi . Doğrulandı.");
		}

	}
	@Override
	public DataResult<List<JobSeeker>> getAll() {
		
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "İş arayanlar listelendi.");
		
	}
	
	


	
}

