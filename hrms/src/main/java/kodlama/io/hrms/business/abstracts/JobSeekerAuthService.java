package kodlama.io.hrms.business.abstracts;


import kodlama.io.hrms.entities.concretes.JobSeeker;

public interface JobSeekerAuthService {

	boolean checkFirstName(JobSeeker jobSeeker);
	boolean checkLastName(JobSeeker jobSeeker);
	boolean checkBirthDate(JobSeeker jobSeeker);
	boolean checkIdNumber(String tcno);
	
	
}
