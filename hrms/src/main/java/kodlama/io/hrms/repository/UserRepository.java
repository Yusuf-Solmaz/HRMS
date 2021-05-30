package kodlama.io.hrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.User;


public interface UserRepository  extends JpaRepository<User, Integer>{

	List<User> findByMail(String mail);
	//List<User> findAllByNationalityId(String id);

}
