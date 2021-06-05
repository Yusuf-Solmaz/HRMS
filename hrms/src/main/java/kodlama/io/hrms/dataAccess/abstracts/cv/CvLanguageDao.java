package kodlama.io.hrms.dataAccess.abstracts.cv;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.cv.CvLanguage;

public interface CvLanguageDao  extends  JpaRepository<CvLanguage, Integer>{

	List<CvLanguage> getByCvId(int id);
}
