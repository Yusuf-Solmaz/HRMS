package kodlama.io.hrms.business.auth.abstracts;



import kodlama.io.hrms.entities.concretes.User;

public interface AuthService {

	
	boolean checkEmail(String email);
	boolean isNullRestartPassword(String restartPassword);
	boolean checkRestartPassword(String restartPassword,User user);
	
	//boolean checkPassword(User user,String restartPassword);
	
}
