
package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.WayOfWorkingService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.WayOfWorkingDao;
import kodlama.io.hrms.entities.concretes.WayOfWorking;



@Service
public class WayOfWorkingManager implements WayOfWorkingService {

	private WayOfWorkingDao wayOfWorkingDao;

	public WayOfWorkingManager(WayOfWorkingDao wayOfWorkingDao) {
		super();
		this.wayOfWorkingDao = wayOfWorkingDao;
	}

	@Override
	public Result add(WayOfWorking wayOfWorking) {
		wayOfWorkingDao.save(wayOfWorking);
		return new SuccessResult("Çalışma şekli eklendi");
	}

	@Override
	public DataResult<List<WayOfWorking>> getAll() {
		return new SuccessDataResult<List<WayOfWorking>>(wayOfWorkingDao.findAll());
	}

	

	

	

}
