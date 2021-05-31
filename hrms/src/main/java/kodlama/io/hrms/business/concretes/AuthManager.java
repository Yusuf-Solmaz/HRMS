package kodlama.io.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;   
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.AuthService;
import kodlama.io.hrms.core.utilities.adapter.EmailService;
import kodlama.io.hrms.dataAccess.abstracts.UserDao;
import kodlama.io.hrms.entities.concretes.User;


@Service

public class AuthManager implements AuthService{

	private UserDao userDao;
	
	private EmailService emailService;
	

	
	
	@Autowired
	public AuthManager(UserDao userDao,  EmailService emailService) {
		super();
		this.userDao = userDao;
		
		this.emailService = emailService;
		
	}


	
	
	@Override
	public boolean checkEmail(String email) {
		
		
		if(!this.emailService.isOkay(email)) {
			
			System.out.println("Geçersiz email.");
			return false;
		}
		
		if(!this.userDao.findByMail(email).isEmpty()) {
			System.out.println("Email sistemde mevcut.");
			return false;
		}
		
		return true;
		
	}

	
	
	

	
	
	

	@Override
	public boolean checkRestartPassword(String restartPassword,User user) {
		
		if(!restartPassword.equals(user.getPassword())) {
			
			return false;
		}
		
		
		else {
			return true;
		}
	}




	
	/*public boolean checkPassword(User user, String restartPassword) {
		if(user.getPassword().isBlank() || user.getPassword().equals(null) ) {
			return false;
			}
			return true;
	}*/




	@Override
	public boolean isNullRestartPassword(String restartPassword) {
		 if(! restartPassword.equals(null)) {
			
			 return false;
		 }
		 
		return true;
	
	}
	
}




	

	

