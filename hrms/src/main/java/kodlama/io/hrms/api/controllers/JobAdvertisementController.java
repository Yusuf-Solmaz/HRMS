package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementController {

	JobAdvertisementService jobAdvertisementService;

@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
}

@GetMapping("/getall")
	public  DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
}

@GetMapping("/getAllActiveAdvertisements")
	public DataResult<List<JobAdvertisement>> getAllIsActiveJobAdvertisementList(){
    	return this.jobAdvertisementService.getAllIsActiveJobAdvertisement();
	}

@GetMapping("/getbyId")
	public DataResult<JobAdvertisement> getById(int id){
		return this.jobAdvertisementService.getById(id);
	}

@PostMapping("/changeActiveToPasive")
	public Result changeOpenToClose(int id){
		return this.jobAdvertisementService.changeActiveToPasive(id);
}

/*@GetMapping("/getAllActiveJobAdvList")
public DataResult<List<JobAdvertisement>> getAllOpenJobAdvertisementList(){
	return this.jobAdvertisementService.getAllIsActiveJobAdvertisement();
}*/

@GetMapping("/findAllJobAdvByPublished")
public DataResult<List<JobAdvertisement>> findByIsOpenTrueOrderByDeadline (){
	return this.jobAdvertisementService.findByIsActiveTrueOrderByAdvertisementDeadline() ;
}

@GetMapping("/getAllActiveJobAdvByEmployer")
public DataResult<List<JobAdvertisement>> getByIsOpenJobAdvertisementOrderByEmployer_Id(@RequestParam int employer_id){
	return this.jobAdvertisementService.getByIsActiveAndId(employer_id);
}





}