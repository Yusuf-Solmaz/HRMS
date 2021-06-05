package kodlama.io.hrms.core.utilities.imageService.cloudinary;

  
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlama.io.hrms.core.utilities.imageService.ImageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryImageManager implements ImageService {

	Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap( "cloud_name", "dtbcdcxdu","api_key", "177659272949476","api_secret", "J8iL_xzD1iqQ14LdGcj5nX90pgg"));
	
	
	@Override
	public DataResult<Map> upload(MultipartFile multipartFile) throws IOException {
		Map<String, Object> specs = new HashMap<>();
		
		var formats = Arrays.asList("png", "bmp", "jpeg", "jpg");
		specs.put("formats", specs);
		
		 File file = converter(multipartFile) ;
		
		Map uploaderMap = null;
		
		try {
			uploaderMap = cloudinary.uploader().upload(file, specs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new SuccessDataResult<Map>(uploaderMap);
	}

	private File converter(MultipartFile multipartFile) {
		File file = new File(multipartFile.getOriginalFilename());
		
		try {
			FileOutputStream stream = new FileOutputStream(file);
			stream.write(multipartFile.getBytes());
			stream.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return file;
	}

	@Override
	public DataResult<Map> delete(String id) throws IOException {
		Map deleteMap = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
		
		return new SuccessDataResult<Map>(deleteMap);
	}

    
}