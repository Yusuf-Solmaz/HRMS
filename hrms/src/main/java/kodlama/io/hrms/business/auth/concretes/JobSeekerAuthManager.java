package kodlama.io.hrms.business.auth.concretes;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.auth.abstracts.JobSeekerAuthService;
import kodlama.io.hrms.core.utilities.adapter.EmailService;
import kodlama.io.hrms.core.utilities.adapter.MernisService;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.io.hrms.dataAccess.abstracts.UserDao;
import kodlama.io.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerAuthManager extends AuthManager implements JobSeekerAuthService  {

	private  JobSeekerDao jobSeekerDao;
	
	private MernisService mernisService;
	
	@Autowired
	public JobSeekerAuthManager(UserDao userDao, MernisService mernisService, EmailService emailService , JobSeekerDao jobSeekerDao ) {
		super(userDao,  emailService  );
		this.jobSeekerDao=jobSeekerDao;
		this.mernisService=mernisService;
	}
	 
	@Override
	public boolean checkFirstName(JobSeeker jobSeeker) {
		if(jobSeeker.getFirstName().isBlank() || jobSeeker.getFirstName().equals(null)) {
		return false;
		}
		return true;
	}

	@Override
	public boolean checkLastName(JobSeeker jobSeeker) {
		
		if(jobSeeker.getLastName().isBlank() || jobSeeker.getLastName().equals(null)) {
		return false;
		}
		return true;
	}

	@Override
	public boolean checkBirthDate(JobSeeker jobSeeker) {
		if(jobSeeker.getBirthDate().equals(null)) {
		return false;
		}
		return true;
	}

	@Override
	public boolean checkIdNumber(String tcno) {
		if (!this.mernisService.isOkay(tcno)) {
			return false;
		}
		if(!this.jobSeekerDao.findAllByNationalityId(tcno).isEmpty()) {
			
			return false;
		}
			
        
         return true;
	}

	

}
	
