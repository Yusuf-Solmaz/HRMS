package kodlama.io.hrms.api.controllers.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.cv.CvExperienceService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.cv.CvEducation;
import kodlama.io.hrms.entities.concretes.cv.CvExperience;

@RestController
@RequestMapping("/api/cvexperiences")
@CrossOrigin
public class CvExperienceController {

	private CvExperienceService cvExperienceService;

	@Autowired
	public CvExperienceController(CvExperienceService cvExperienceService) {
		super();
		this.cvExperienceService = cvExperienceService;
	}
	

	@GetMapping("/getAll")
	public DataResult<List<CvExperience>> getAll() {
		return this.cvExperienceService.getAll();
	}
	
	@GetMapping("/getCvExperiencesByStartDateDesc")
	public DataResult<List<CvExperience>> orderCvExperienceByStarDateDesc(int id) {
		return this.cvExperienceService.orderCvExperiencesByStartDateDesc(id);
	}
	@PostMapping("/addToCv")
	public Result add(@RequestBody CvExperience cvExperience,@RequestParam int jobSeekerId) {
		return this.cvExperienceService.addExperienceTocv(cvExperience,jobSeekerId);
	}
	
}
