package kodlama.io.hrms.business.concretes.cv;

import kodlama.io.hrms.business.abstracts.cv.CvExperienceService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.io.hrms.dataAccess.abstracts.cv.CvDao;
import kodlama.io.hrms.dataAccess.abstracts.cv.CvExperienceDao;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import kodlama.io.hrms.entities.concretes.cv.Cv;
import kodlama.io.hrms.entities.concretes.cv.CvExperience;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CvExperienceManager implements CvExperienceService{

	private CvExperienceDao cvExperienceDao;
	private CvDao cvDao;
	private JobSeekerDao jobSeekerDao;
	
	@Autowired
	public CvExperienceManager(CvExperienceDao cvExperienceDao, CvDao cvDao,JobSeekerDao jobSeekerDao) {
		super();
		this.cvExperienceDao = cvExperienceDao;
		this.cvDao = cvDao;
		this.jobSeekerDao=jobSeekerDao;
	}

	@Override
	public DataResult<List<CvExperience>> getAll() {
		return new SuccessDataResult<List<CvExperience>>
		(this.cvExperienceDao.findAll(), "İş deneyimleri listelendi.");
	}

	@Override
	public DataResult<List<CvExperience>> orderCvExperiencesByStartDateDesc(int id) {
		
		if (this.cvDao.existsById(id)) {
			return new SuccessDataResult<List<CvExperience>>
			(this.cvExperienceDao.getCvExperienceByStartDateDesc(id), "Aranan adayın iş deneyimleri listelendi.");
		}
		
		return new ErrorDataResult<List<CvExperience>>("Cv ID Bulunamadı. ");
	}

	@Override
	public Result addExperienceTocv(CvExperience cvExperience, int jobSeekerId) {
		JobSeeker jobSeeker = this.jobSeekerDao.getById(jobSeekerId);
		
		Cv cv = this.cvDao.getByJobSeeker(jobSeeker);
		
		cvExperience.setCv(cv);
		
		
		this.cvExperienceDao.save(cvExperience);
		
		
		return new SuccessResult("Deneyim eklendi.");
	}

	}


