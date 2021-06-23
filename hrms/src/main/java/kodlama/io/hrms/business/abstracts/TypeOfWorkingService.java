package kodlama.io.hrms.business.abstracts;

import java.util.List; 

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.TypeOfWorking;

public interface TypeOfWorkingService {

	Result add(TypeOfWorking typeOfWorking);

	DataResult<List<TypeOfWorking>> getAll();

}
