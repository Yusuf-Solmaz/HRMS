package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.TypeOfWorking;

public interface TypeOfWorkingDao extends JpaRepository<TypeOfWorking, Integer>{

}