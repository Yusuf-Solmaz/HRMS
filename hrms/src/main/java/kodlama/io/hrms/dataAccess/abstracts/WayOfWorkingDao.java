package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.WayOfWorking;

public interface WayOfWorkingDao extends JpaRepository<WayOfWorking, Integer> {

}