package kodlama.io.hrms.business.abstracts.cv;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.cv.CvEducation;
import kodlama.io.hrms.entities.concretes.cv.CvLanguage;
import kodlama.io.hrms.entities.concretes.cv.Language;

public interface CvLanguageService {
	
	DataResult<List<CvLanguage>> getAll();
	
	DataResult<List<CvLanguage>> getByCvId(int id);
	
	Result addLanguageToCv(Language language, int jobSeekerId);
}
