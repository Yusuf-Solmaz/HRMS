package kodlama.io.hrms.dataAccess.abstracts.cv;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.cv.Language;

public interface LanguageDao extends JpaRepository<Language, Integer>{

}
