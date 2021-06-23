package kodlama.io.hrms.business.concretes.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.cv.CvLanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.io.hrms.dataAccess.abstracts.cv.CvDao;
import kodlama.io.hrms.dataAccess.abstracts.cv.CvLanguageDao;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import kodlama.io.hrms.entities.concretes.cv.Cv;
import kodlama.io.hrms.entities.concretes.cv.CvLanguage;
import kodlama.io.hrms.entities.concretes.cv.Language;

@Service
public class CvLanguageManager implements CvLanguageService{

	
	private CvLanguageDao cvLanguageDao;
	private CvDao cvDao;
	private JobSeekerDao jobSeekerDao;
	
	
	@Autowired
	public CvLanguageManager(CvLanguageDao cvLanguageDao, CvDao cvDao, JobSeekerDao jobSeekerDao) {
		super();
		this.cvLanguageDao = cvLanguageDao;
		this.cvDao = cvDao;
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public DataResult<List<CvLanguage>> getAll() {
		return new SuccessDataResult<List<CvLanguage>>
		(this.cvLanguageDao.findAll(), "Bütün adayların konuşabildiği diller listelendi.");
	}

	@Override
	public DataResult<List<CvLanguage>> getByCvId(int id) {
		return new SuccessDataResult<List<CvLanguage>>
		(this.cvLanguageDao.getByCvId(id));
	}

	@Override
	public Result addLanguageToCv(Language language, int jobSeekerId) {
		
		JobSeeker jobSeeker = this.jobSeekerDao.getById(jobSeekerId);
		
		Cv cv = this.cvDao.getByJobSeeker(jobSeeker);
		
		CvLanguage cvLanguage = new CvLanguage(cv, language);
		
		
		this.cvLanguageDao.save(cvLanguage);
		
		return new SuccessResult("Konuşulan dil CV'ye eklendi.");
	}

   

}
