package kodlama.io.hrms.business.concretes.cv;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.business.abstracts.cv.CvService;
import kodlama.io.hrms.core.utilities.imageService.ImageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.cv.CvDao;
import kodlama.io.hrms.dataAccess.abstracts.cv.CvEducationDao;
import kodlama.io.hrms.dataAccess.abstracts.cv.CvExperienceDao;
import kodlama.io.hrms.dataAccess.abstracts.cv.CvLanguageDao;
import kodlama.io.hrms.dataAccess.abstracts.cv.CvSkillDao;
import kodlama.io.hrms.entities.concretes.cv.Cv;
import kodlama.io.hrms.entities.concretes.cv.CvEducation;
import kodlama.io.hrms.entities.concretes.cv.CvExperience;
import kodlama.io.hrms.entities.concretes.cv.CvLanguage;
import kodlama.io.hrms.entities.concretes.cv.CvSkill;

@Service
public class CvManager implements CvService {

	private CvDao cvDao;
	private CvSkillDao skillDao;
	private CvLanguageDao languageDao;
	private CvEducationDao educationDao;
	private CvExperienceDao experienceDao;
	private ImageService imageService;
	
	
	
	
	
	@Autowired
	public CvManager(CvDao cvDao, CvSkillDao skillDao, CvLanguageDao languageDao, CvEducationDao educationDao,
			CvExperienceDao experienceDao, ImageService imageService) {
		super();
		this.cvDao = cvDao;
		this.skillDao = skillDao;
		this.languageDao = languageDao;
		this.educationDao = educationDao;
		this.experienceDao = experienceDao;
		this.imageService = imageService;
	}

	@Override
	public DataResult<List<Cv>> getAll() {
		return new SuccessDataResult<List<Cv>>
		(this.cvDao.findAll(), "CV'ler listelendi.");
	}

	@Override
	public Result add(Cv cv) {
		var tempCv = this.cvDao.save(cv);
		
		if (tempCv != null) {
			if (tempCv.getCvExperiences() != null) {
				for (CvExperience experience : tempCv.getCvExperiences()) {
					experience.setCv(tempCv);
					experience.setId(tempCv.getId());
					this.experienceDao.save(experience);
				}
			}
			
			if (tempCv.getCvEducations() != null) {
				for (CvEducation cvEducations : tempCv.getCvEducations()) {
					cvEducations.setCv(tempCv);
					cvEducations.setId(tempCv.getId());
					this.educationDao.save(cvEducations);
				}
			}
			
			if (tempCv.getCvSkills() != null) {
				for (CvSkill cvTalent : tempCv.getCvSkills()) {
					cvTalent.setCv(tempCv);
					cvTalent.setId(tempCv.getId());
					this.skillDao.save(cvTalent);
				}
			}
			
			
			if (tempCv.getCvLanguages() != null) {
				for (CvLanguage cvLanguage : tempCv.getCvLanguages()) {
					cvLanguage.setCv(tempCv);
					cvLanguage.setId(tempCv.getId());
					this.languageDao.save(cvLanguage);
				}
			}
			
		}
		
		return new SuccessResult("İş arayan CV'si eklendi.");
	}

	@Override
	public Result uploadCvPhoto(int id, MultipartFile multipartFile) throws IOException {
		var upload = this.imageService.upload(multipartFile);
		var link = upload.getData().get("url");
		
		Cv tempCv = this.cvDao.getOne(id);
		tempCv.setPhotoLink(link.toString());
		this.cvDao.save(tempCv);
		
		return new SuccessResult("Resim yüklendi.");
	}

	@Override
	public DataResult<List<Cv>> getByJobSeekerId(int id) {
		return new SuccessDataResult<List<Cv>>
		(this.cvDao.getByJobSeekerId(id));
	}

	@Override
	public DataResult<Cv> update(Cv cv) {
		Cv tempCv = this.cvDao.findById(cv.getId());
		
		if (cv.getDescription() != null) {
			tempCv.setDescription(cv.getDescription());
		}
		
		if (cv.getPhotoLink() != null) {
			tempCv.setPhotoLink(cv.getPhotoLink());
		}
		
		if (cv.getGithub() != null) {
			tempCv.setGithub(cv.getGithub());
		}
		
		if (cv.getLinkedin() != null) {
			tempCv.setLinkedin(cv.getLinkedin());
		}
		
		if (cv.getCvExperiences() != null) {
			tempCv.setCvExperiences(cv.getCvExperiences());
		}
		
		if (cv.getCvLanguages() != null) {
			tempCv.setCvLanguages(cv.getCvLanguages());
		}
		
		if (cv.getCvSkills() != null) {
			tempCv.setCvSkills(cv.getCvSkills());
		}
		
		if (cv.getCvEducations() != null) {
			tempCv.setCvEducations(cv.getCvEducations());
		}
		
		if (cv.isActive() != tempCv.isActive()) {
			tempCv.setActive(cv.isActive());
		}
		
		
		return new SuccessDataResult<Cv>
		(this.cvDao.save(tempCv), "CV bilgileri güncellendi.");
	}

 
   

}
