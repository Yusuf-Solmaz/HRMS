package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.Result; 
import kodlama.io.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	Result add(JobAdvertisement jobAdvertisement);
}
