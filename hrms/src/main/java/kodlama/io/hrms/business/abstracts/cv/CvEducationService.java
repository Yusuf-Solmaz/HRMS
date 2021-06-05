package kodlama.io.hrms.business.abstracts.cv;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.cv.CvEducation;

public interface CvEducationService {

	DataResult<List<CvEducation>> getAll();
	
	DataResult<List<CvEducation>> getByCvId(int id);
	
	DataResult<CvEducation> update(CvEducation cvEducation);
	
	Result add(CvEducation cavSchool);
	
	DataResult<List<CvEducation>> orderCvEducationsByGraduationYearDesc(int id);
}
