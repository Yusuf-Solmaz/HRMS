package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.business.auth.concretes.JobAdvertisementAuthManager;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
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

	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll());
	}

	@Override
    public DataResult<List<JobAdvertisement>> getAllIsActiveJobAdvertisement() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllIsActiveJobAdvertisementList());
    }

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByAdvertisementDeadline() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrueOrderByAdvertisementDeadline());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveAndId(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveAndEmployer_Id(true, employerId));
	}

	@Override
	public Result changeActiveToPasive(int id) {
		if (getById(id) == null) {
			return new ErrorResult("Böyle bir iş ilanı bulunamadı.");

		}
		if (getById(id).getData().isActive() == false) {
			return new ErrorResult("");
		}

		JobAdvertisement jobAdvertisement = getById(id).getData();
		jobAdvertisement.setActive(false);
		update(jobAdvertisement);
		return new SuccessResult("İş ilanı kapatıldı.");
	}

	@Override
	public DataResult<JobAdvertisement> getById(int id) {
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getByJobAdvertisementId(id));
	}

	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı güncellendi.");
	}

}
