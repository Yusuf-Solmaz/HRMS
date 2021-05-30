package kodlama.io.hrms.business.concretes;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
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
	public DataResult<Employer> add(Employer employer, String restartPassword) {

		if(!employerAuthManager.checkCompanyName(employer)) {
			return new ErrorDataResult<Employer>("Şirket adı boş bırakılamaz.");
		}
		else if(!employerAuthManager.checkEmail(employer.getMail())) {
			return new ErrorDataResult<Employer>("Geçersiz mail.");
		}
		else if(!employerAuthManager.checkRestartPassword(restartPassword,employer)) {
			return new ErrorDataResult<Employer>("Şifre tekrarı geçersiz.");
		}
		
		else if(!employerAuthManager.checkPhoneNumber(employer)) {
			return new ErrorDataResult<Employer>("Telafon numarası boş bırakılamaz.");
		}
		else {
			return new SuccessDataResult<Employer>(this.employerDao.save(employer),"İş veren hesabı eklendi . Onaylandı.");
			}
	}



	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "İş verenler listelendi.");
	}


}
