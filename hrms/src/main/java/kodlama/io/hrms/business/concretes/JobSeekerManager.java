package kodlama.io.hrms.business.concretes;

import java.util.List;      

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.business.auth.abstracts.JobSeekerAuthService;
import kodlama.io.hrms.business.auth.concretes.JobSeekerAuthManager;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.io.hrms.entities.concretes.JobSeeker;


@Service


public class JobSeekerManager implements JobSeekerService{

	private JobSeekerDao jobSeekerDao;
	private JobSeekerAuthManager jobSeekerAuthManager;
	
	
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, JobSeekerAuthManager jobSeekerAuthManager) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.jobSeekerAuthManager = jobSeekerAuthManager;
		
	}
	
	
	@Override
	public Result add(JobSeeker jobSeeker , String restartPassword  ) {
		
		if(!jobSeekerAuthManager.checkFirstName(jobSeeker) ) {
			return new ErrorResult("Ad boş bırakılamaz.");
		}
		else if(!jobSeekerAuthManager.checkLastName(jobSeeker)) {
			return new ErrorResult("Soyad boş bırakılamaz.");
		}
		else if(!jobSeekerAuthManager.checkBirthDate(jobSeeker)) {
			return new ErrorResult("Doğum tarihi boş bırakılamaz.");
		}
		
		else if(!jobSeekerAuthManager.checkRestartPassword(restartPassword, jobSeeker)) {
			return new ErrorResult("Şifre veya şifre tekrarı boş bırakılamaz.");
		}
		else if(!jobSeekerAuthManager.checkIdNumber(jobSeeker.getNationalityId())) {
			
			return new ErrorResult("TC no yanlış.");
		}
		else if(!jobSeekerAuthManager.checkEmail(jobSeeker.getMail())) {
			
			return new ErrorResult("Geçersiz email.");
		}
		else if(!jobSeekerAuthManager.checkRestartPassword(restartPassword, jobSeeker)) {
			
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

