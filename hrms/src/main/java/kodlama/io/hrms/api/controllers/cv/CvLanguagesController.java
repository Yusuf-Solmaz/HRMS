package kodlama.io.hrms.api.controllers.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.cv.CvLanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.cv.CvLanguage;
import kodlama.io.hrms.entities.concretes.cv.Language;

@RestController
@RequestMapping("/api/cvlanguages")
@CrossOrigin
public class CvLanguagesController {

	private CvLanguageService cvLanguageService;

	@Autowired
	public CvLanguagesController(CvLanguageService cvLanguageService) {
		super();
		this.cvLanguageService = cvLanguageService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CvLanguage>> getAll() {
		return this.cvLanguageService.getAll();
	}
	
	@GetMapping("/getByJobSeekerCvId")
	public DataResult<List<CvLanguage>> getByCvsId(int id) {
		return this.cvLanguageService.getByCvId(id);
	}
	
	
	@PostMapping("/addLanguageToCv")
	public Result addLanguageToCv(@RequestBody Language language, @RequestParam int jobSeekerId) {
		return this.cvLanguageService.addLanguageToCv(language, jobSeekerId);
	}
}
