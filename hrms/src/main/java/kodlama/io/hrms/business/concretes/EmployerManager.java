package kodlama.io.hrms.business.concretes;

import java.util.List;    

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.business.auth.concretes.EmployerAuthManager;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.entities.concretes.Employer;

 
@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private EmployerAuthManager employerAuthManager;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmployerAuthManager employerAuthManager) {
		super();
		this.employerDao = employerDao;
		this.employerAuthManager = employerAuthManager;
	}



	@Override
	public Result add(Employer employer, String restartPassword) {

		if(!employerAuthManager.checkCompanyName(employer)) {
			return new ErrorResult("Şirket adı boş bırakılamaz.");
		}
		else if(!employerAuthManager.checkEmail(employer.getMail())) {
			return new ErrorResult("Geçersiz mail.");
		}
		else if(!employerAuthManager.checkRestartPassword(restartPassword,employer)) {
			return new ErrorResult("Şifre tekrarı geçersiz.");
		}
		
		else if(!employerAuthManager.checkPhoneNumber(employer)) {
			return new ErrorResult("Telafon numarası boş bırakılamaz.");
		}
		
		else if(employerAuthManager.EmployerDomainCheck(employer)) {
			return new ErrorResult("Web site ve email aynı domaine sahip olmalıdır.");
		}
		
		else {
			this.employerDao.save(employer);
			return new SuccessResult("İş veren hesabı eklendi . Onaylandı.");
			}
	}



	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "İş verenler listelendi.");
	}


}
