package kodlama.io.hrms.business.concretes.cv;

import kodlama.io.hrms.business.abstracts.cv.CvEducationService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.io.hrms.dataAccess.abstracts.cv.CvDao;
import kodlama.io.hrms.dataAccess.abstracts.cv.CvEducationDao;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import kodlama.io.hrms.entities.concretes.cv.Cv;
import kodlama.io.hrms.entities.concretes.cv.CvEducation;
import kodlama.io.hrms.entities.concretes.cv.CvSkill;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CvEducationManager implements CvEducationService{

	private  CvEducationDao cvEducationDao;
	private CvDao cvDao;
	private JobSeekerDao jobSeekerDao;
	
	
	@Autowired
	public CvEducationManager(CvEducationDao cvEducationDao, CvDao cvDao, JobSeekerDao jobSeekerDao) {
		super();
		this.cvEducationDao = cvEducationDao;
		this.cvDao = cvDao;
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public DataResult<List<CvEducation>> getAll() {
		return new SuccessDataResult<List<CvEducation>>
		(this.cvEducationDao.findAll(), "Okullar listelendi.");
	}

	@Override
	public DataResult<List<CvEducation>> getByCvId(int id) {
		return new SuccessDataResult<List<CvEducation>>
		(this.cvEducationDao.getByCvId(id));	
	}

	@Override
	public DataResult<CvEducation> update(CvEducation cvEducation) {
		CvEducation tempSchool = this.cvEducationDao.findById(cvEducation.getId());
		
		if (cvEducation.getGraduationYear() != null) {
			tempSchool.setGraduationYear(cvEducation.getGraduationYear());
		}
		
		if (cvEducation.getSchoolName() != null) {
			tempSchool.setSchoolName(cvEducation.getSchoolName());
		}
		
		if (cvEducation.getDepartmentName() != null) {
			tempSchool.setDepartmentName(cvEducation.getDepartmentName());
		}
		
		if (cvEducation.getStartYear() != null) {
			tempSchool.setStartYear(cvEducation.getStartYear());
		}
		
		return new SuccessDataResult<CvEducation>
		(this.cvEducationDao.save(tempSchool), "Eğitim bilgileri güncellendi.");
		
	}

	@Override
	public Result addEducationTocv(CvEducation cvSchool,int jobSeekerId) {
		JobSeeker jobSeeker = this.jobSeekerDao.getById(jobSeekerId);
		
		Cv cv = this.cvDao.getByJobSeeker(jobSeeker);
		
		cvSchool.setCv(cv);
		
		
		this.cvEducationDao.save(cvSchool);
		
		
		return new SuccessResult("Eğitim eklendi.");
	}

	@Override
	public DataResult<List<CvEducation>> orderCvEducationsByGraduationYearDesc(int id) {
		if (this.cvDao.existsById(id)) {
			return new SuccessDataResult<List<CvEducation>>
			(this.cvEducationDao.getCvEducationOrderByGraduationYearDesc(id),"Aranan eğitimler listelendi.");
		}
		
		return new ErrorDataResult<List<CvEducation>>
		("Cv ID bulunamadı.");
	}
	
}
