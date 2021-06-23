package kodlama.io.hrms.api.controllers;
  
import java.util.List;   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import kodlama.io.hrms.entities.dtos.JobPostingAddDto;


@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployerController {

	EmployerService employerService;
	JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public EmployerController(EmployerService employerService,JobAdvertisementService jobAdvertisementService)
	{
		this.employerService=employerService;
		this.jobAdvertisementService=jobAdvertisementService;
	}
	
	@GetMapping("/getall")
    public DataResult<List<Employer>> getAll()
    {
        return this.employerService.getAll();
    }
	
	@PostMapping("/add")
	public Result add(@RequestBody Employer employer, String restartPassword)
	{
		return this.employerService.add(employer , restartPassword);
	}
	
	@PostMapping("/add/advertisemet")
	public Result add(@RequestBody JobPostingAddDto jobPostingAddDto)
	{
		return this.jobAdvertisementService.add(jobPostingAddDto);
	}
	
}
