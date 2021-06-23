package kodlama.io.hrms.api.controllers.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.cv.CvSkillService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.cv.CvSkill;
import kodlama.io.hrms.entities.concretes.cv.Skill;

@RestController
@RequestMapping("/api/cvSkills")
@CrossOrigin
public class CvSkillsController {

	private CvSkillService cvSkillService;

	@Autowired
	public CvSkillsController(CvSkillService cvSkillService) {
		super();
		this.cvSkillService = cvSkillService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CvSkill>> getAll() {
		return this.cvSkillService.getAll();
	}
	
	@GetMapping("/getByCandidateCvId")
	public DataResult<List< CvSkill>> getByCvsId(int id) {
		return this.cvSkillService.getByCvId(id);
	}
	
	@PostMapping("/addTalentToCv")
	public Result addSkillToCv(@RequestBody Skill skill, @RequestParam int jobSeekerId) {
		return this.cvSkillService.addSkillToCv(skill, jobSeekerId);
	}
}
