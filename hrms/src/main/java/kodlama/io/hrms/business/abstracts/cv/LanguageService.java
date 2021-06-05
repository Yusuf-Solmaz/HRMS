package kodlama.io.hrms.business.abstracts.cv;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.cv.Language;

public interface LanguageService {

	DataResult<List<Language>> getAll();
	
	Result add(Language language);
}
