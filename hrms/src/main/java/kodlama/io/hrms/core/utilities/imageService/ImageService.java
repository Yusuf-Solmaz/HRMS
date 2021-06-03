package kodlama.io.hrms.core.utilities.imageService;

import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.core.utilities.results.DataResult;

public interface ImageService {

	 DataResult<?> save(MultipartFile file);
}
