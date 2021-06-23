package kodlama.io.hrms.api.controllers.cv;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.business.abstracts.cv.CvEducationService;
import kodlama.io.hrms.business.abstracts.cv.CvExperienceService;
import kodlama.io.hrms.business.abstracts.cv.CvLanguageService;
import kodlama.io.hrms.business.abstracts.cv.CvService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.cv.Cv;

@RestController
@RequestMapping("/api/cvs")
@CrossOrigin
public class CvsController {

	private CvService cvService;

	@Autowired
	public CvsController(CvService cvService) {
		super();
		this.cvService = cvService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Cv>> getAll() {
		return this.cvService.getAll();
	}
	
	@PostMapping("/addCvPhoto")
	public Result uploadCvPhoto(int id, MultipartFile multipartFile) throws IOException {
		return this.cvService.uploadCvPhoto(id, multipartFile);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Cv cv) {
		return this.cvService.add(cv);
	}
	
	@GetMapping("/getByJobSeekerId")
	public DataResult<List<Cv>> getByJobSeekersId(@RequestParam int id) {
		return this.cvService.getByJobSeekerId(id);
	}
	
	@PostMapping("/update")
	public DataResult<Cv> update(@RequestBody Cv cv) {
		return this.cvService.update(cv);
	}
	
}
