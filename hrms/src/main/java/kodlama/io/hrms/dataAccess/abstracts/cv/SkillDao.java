package kodlama.io.hrms.dataAccess.abstracts.cv;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.cv.Skill;

public interface SkillDao extends JpaRepository<Skill, Integer>{

}
