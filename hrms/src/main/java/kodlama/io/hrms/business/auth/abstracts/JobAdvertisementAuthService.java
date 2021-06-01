package kodlama.io.hrms.business.auth.abstracts;

import kodlama.io.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementAuthService {

	boolean checkJobDescription(JobAdvertisement jobAdvertisement);
    boolean checkOpenPositions(JobAdvertisement jobAdvertisement);
    boolean checkAdvertisementsDeadline(JobAdvertisement jobAdvertisement);
    boolean checkCreationDate(JobAdvertisement jobAdvertisement);
    boolean checkSalary(JobAdvertisement jobAdvertisement);

	





}
