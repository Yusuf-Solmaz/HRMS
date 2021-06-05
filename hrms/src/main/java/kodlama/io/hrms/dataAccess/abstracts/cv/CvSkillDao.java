package kodlama.io.hrms.dataAccess.abstracts.cv;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.cv.CvSkill;

public interface CvSkillDao  extends  JpaRepository<CvSkill, Integer>{

	List<CvSkill> getByCvId(int id);
}
