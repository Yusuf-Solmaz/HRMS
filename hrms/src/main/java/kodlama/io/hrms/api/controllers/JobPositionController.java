package kodlama.io.hrms.api.controllers;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobPositionService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobPosition;



@RestController
@RequestMapping("/api/jobs")
@CrossOrigin
public class JobPositionController {

	private JobPositionService jobService;

	@Autowired
	public JobPositionController(JobPositionService jobService) {
		super();
		this.jobService = jobService;
	}
	
	@PostMapping
	public Result add(@RequestBody JobPosition jobPosition) {
		return  this.jobService.add(jobPosition);
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPosition>> getAll(){
		
		return this.jobService.getAll();
	}
}
