package kodlama.io.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobSeekerImage;

public interface JobSeekerImageService {

	Result add(JobSeekerImage jobSeekerImage);
    Result add(JobSeekerImage jobSeekerImage, MultipartFile file);
    DataResult<List<JobSeekerImage>> getAll();
    DataResult<List<JobSeekerImage>> getAllByJobSeekerId(int jobSeekerId);
}
