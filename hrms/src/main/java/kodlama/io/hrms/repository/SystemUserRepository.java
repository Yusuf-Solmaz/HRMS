package kodlama.io.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.SystemUser;



public interface SystemUserRepository  extends JpaRepository<SystemUser, Integer>{

}
