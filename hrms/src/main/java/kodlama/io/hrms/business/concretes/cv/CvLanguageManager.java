package kodlama.io.hrms.business.concretes.cv;

import java.util.List;

import kodlama.io.hrms.business.abstracts.cv.CvLanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.cv.CvEducation;


import org.springframework.stereotype.Service;

@Service
public class CvLanguageManager implements CvLanguageService{

	@Override
	public Result add(CvEducation cvEducation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<CvEducation>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<CvEducation>> getAllByCandidateIdOrderByGraduationYear(int candidateId) {
		// TODO Auto-generated method stub
		return null;
	}

}
