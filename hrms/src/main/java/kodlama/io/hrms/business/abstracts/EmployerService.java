package kodlama.io.hrms.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Component;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employer;


@Component
public interface EmployerService {

	Result add(Employer employer , String restartPassword);
	
	DataResult<List<Employer>> getAll();

}
