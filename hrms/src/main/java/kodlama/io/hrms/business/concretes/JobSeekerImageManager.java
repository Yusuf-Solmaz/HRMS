package kodlama.io.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.business.abstracts.JobSeekerImageService;
import kodlama.io.hrms.core.utilities.imageService.ImageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.cv.JobSeekerImageDao;
import kodlama.io.hrms.entities.concretes.JobSeekerImage;

@Service
public class JobSeekerImageManager implements JobSeekerImageService{
	
	private JobSeekerImageDao jobSeekerImageDao;
    private ImageService imageService;
	
	@Autowired
    public JobSeekerImageManager(JobSeekerImageDao jobSeekerImageDao, ImageService imageService) {
		super();
		this.jobSeekerImageDao = jobSeekerImageDao;
		this.imageService = imageService;
	}

	@Override
	public Result add(JobSeekerImage jobSeekerImage) {
		this.jobSeekerImageDao.save(jobSeekerImage);
		return new SuccessResult("Resim ekleme başarılı.");
	}

	@Override
	public Result add(JobSeekerImage jobSeekerImage, MultipartFile file) {
		Map<String,String> result = (Map<String,String>)imageService.save(file).getData();
        String url = result.get("url");
        jobSeekerImage.setUrl(url);
        jobSeekerImage.setUploadedAt(LocalDate.now());
        return add(jobSeekerImage);
	}

	@Override
	public DataResult<List<JobSeekerImage>> getAll() {
		
		return new SuccessDataResult<List<JobSeekerImage>>(this.jobSeekerImageDao.findAll(), "Resimler listelendi.");
	}

	@Override
	public DataResult<List<JobSeekerImage>> getAllByJobSeekerId(int jobSeekerId) {
		
		return new SuccessDataResult<List<JobSeekerImage>>(this.jobSeekerImageDao.getAllByJobSeekerId(jobSeekerId));
	}

}
