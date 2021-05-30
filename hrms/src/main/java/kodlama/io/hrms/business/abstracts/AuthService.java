package kodlama.io.hrms.business.abstracts;



import kodlama.io.hrms.entities.concretes.User;

public interface AuthService {

	
	boolean checkEmail(String email);
	
	
	boolean checkRestartPassword(String restartPassword,User user);
	//boolean checkPassword(User user,String restartPassword);
	boolean isNullRestartPassword(String restartPassword);
}
