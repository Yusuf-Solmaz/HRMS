package kodlama.io.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.business.abstracts.JobSeekerImageService;
import kodlama.io.hrms.entities.concretes.JobSeekerImage;
import kodlama.io.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/candidateimages")
public class JobSeekerImagesController {
	
	private JobSeekerImageService jobSeekerImageService;
	
	@Autowired
    public JobSeekerImagesController(JobSeekerImageService jobSeekerImageService) {
        this.jobSeekerImageService = jobSeekerImageService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@RequestBody MultipartFile file,@RequestParam int candidateId) {
        JobSeekerImage jobSeekerImage = new JobSeekerImage();
        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.setId(candidateId);
        jobSeekerImage.setJobSeeker(jobSeeker);
        return ResponseEntity.ok(this.jobSeekerImageService.add(jobSeekerImage,file));
    }


    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.jobSeekerImageService.getAll());
    }
}
	

