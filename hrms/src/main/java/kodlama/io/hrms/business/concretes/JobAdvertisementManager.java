package kodlama.io.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	private JobAdvertisementAuthManager jobAdvertisementAuthManager;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementAuthManager jobAdvertisementAuthManager,JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementAuthManager = jobAdvertisementAuthManager;
		this.jobAdvertisementDao=jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		  if(!jobAdvertisementAuthManager.checkJobDescription(jobAdvertisement)) {
	            return new ErrorResult("İş tanımı boş olamaz!");
	        }
	        else if(!jobAdvertisementAuthManager.checkOpenPositions(jobAdvertisement)) {
	            return new ErrorResult("Açık Pozisyon Sayısını Giriniz");
	        }
	        else if(!jobAdvertisementAuthManager.checkAdvertisementsDeadline(jobAdvertisement)) {
	            return new ErrorResult("Geçerli bir son başvuru tarihi giriniz!");
	        }
	        else if(!jobAdvertisementAuthManager.checkCreationDate(jobAdvertisement)) {
	            return new ErrorResult("Oluşturulma Tarihi Boş Bırakılamaz");
	        }
	        else if(!jobAdvertisementAuthManager.checkSalary(jobAdvertisement)) {
	            return new ErrorResult("Maksimum maaş minumum maaştan küçük olamaz!");
	        }
	        else {
	        	this.jobAdvertisementDao.save(jobAdvertisement);
	        	return new SuccessResult("İlan ekleme başarılı.");
	        
	        }
	}

}
