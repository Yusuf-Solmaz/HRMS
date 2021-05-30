package kodlama.io.hrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.JobSeeker;

public interface  EmployerRepository  extends  JpaRepository<Employer, Integer>{

	List<JobSeeker> findAllByPhoneNumber(String phoneNumber);
}
