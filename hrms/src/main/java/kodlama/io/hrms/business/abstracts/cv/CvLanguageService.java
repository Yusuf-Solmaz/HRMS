package kodlama.io.hrms.business.abstracts.cv;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.cv.CvEducation;

public interface CvLanguageService {

	Result add(CvEducation cvEducation);
    DataResult<List<CvEducation>> getAll();
    DataResult<List<CvEducation>> getAllByCandidateIdOrderByGraduationYear(int candidateId);
	
	
}
