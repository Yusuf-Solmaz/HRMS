package kodlama.io.hrms.business.auth.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.auth.abstracts.JobAdvertisementAuthService;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementAuthManager implements JobAdvertisementAuthService{

	@Override
    public boolean checkJobDescription(JobAdvertisement jobAdvertisement) {
        if(jobAdvertisement.getJobDescription().isBlank() || jobAdvertisement.getJobDescription().equals(null)) {
            return false;
            }
            return true;
    }

    @Override
    public boolean checkOpenPositions(JobAdvertisement jobAdvertisement) {
        if(jobAdvertisement.getOpenPosition().equals(null) || jobAdvertisement.getOpenPosition().equals(0)) {
            return false;
            }
            return true;
    }

    @Override
    public boolean checkAdvertisementsDeadline(JobAdvertisement jobAdvertisement) {
        if(jobAdvertisement.getAdvertisementDeadline().equals(null)) {
            return false;
            }
            return true;
    }

    @Override
    public boolean checkCreationDate(JobAdvertisement jobAdvertisement) {
        if(jobAdvertisement.getCreationDate().equals(null)) {
            return false;
            }
            return true;
    }

    @Override
    public boolean checkSalary(JobAdvertisement jobAdvertisement) {
        if(jobAdvertisement.getMaxSalary() < jobAdvertisement.getMinSalary()) {
            return false;
            }
            return true;
    }

	@Override
	public boolean CheckField(JobAdvertisement jobAdvertisement) {
		
	        if (jobAdvertisement.getJobPosition() != null && jobAdvertisement.getJobDescription() != null && jobAdvertisement.getCity() != null
	                && jobAdvertisement.getCreationDate() != null && jobAdvertisement.getOpenPosition() != 0) {
	            return true;
	        }
	        return false;
	    
	}

}
