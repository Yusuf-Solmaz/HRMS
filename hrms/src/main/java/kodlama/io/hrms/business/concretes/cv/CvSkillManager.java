package kodlama.io.hrms.business.concretes.cv;

import kodlama.io.hrms.business.abstracts.cv.CvSkillService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.io.hrms.dataAccess.abstracts.cv.CvDao;
import kodlama.io.hrms.dataAccess.abstracts.cv.CvSkillDao;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import kodlama.io.hrms.entities.concretes.cv.Cv;
import kodlama.io.hrms.entities.concretes.cv.CvSkill;
import kodlama.io.hrms.entities.concretes.cv.Skill;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CvSkillManager implements CvSkillService{

	private CvSkillDao cvSkillDao;
	private JobSeekerDao jobSeekerDao;
	private CvDao cvDao;
	
	
	@Autowired
	public CvSkillManager(CvSkillDao cvSkillDao, JobSeekerDao jobSeekerDao, CvDao cvDao) {
		super();
		this.cvSkillDao = cvSkillDao;
		this.jobSeekerDao = jobSeekerDao;
		this.cvDao = cvDao;
	}

	@Override
	public DataResult<List<CvSkill>> getAll() {
		return new SuccessDataResult<List<CvSkill>>
		(this.cvSkillDao.findAll(), "Veri listelendi.");
	}

	@Override
	public DataResult<List<CvSkill>> getByCvId(int id) {
		return new SuccessDataResult<List<CvSkill>>
		(this.cvSkillDao.getByCvId(id));
	}

	@Override
	public Result addSkillToCv(Skill skill, int jobSeekerId) {
		JobSeeker jobSeeker = this.jobSeekerDao.getById(jobSeekerId);
		
		Cv cv = this.cvDao.getByJobSeeker(jobSeeker);
		
		CvSkill cvSkill = new CvSkill(cv, skill);
		
		
		this.cvSkillDao.save(cvSkill);
		
		return new SuccessResult("Beceri CV'ye eklendi.");
	}

}
