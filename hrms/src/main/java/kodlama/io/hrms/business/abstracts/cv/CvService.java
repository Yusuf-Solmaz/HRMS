package kodlama.io.hrms.business.abstracts.cv;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.cv.Cv;

public interface CvService {

	DataResult<List<Cv>> getAll();
    
	Result add(Cv cv);
	
	Result uploadCvPhoto(int id, MultipartFile multipartFile) throws IOException;
	
	DataResult<List<Cv>> getByJobSeekerId(int id);
	
	DataResult<Cv> update(Cv cv);
}
