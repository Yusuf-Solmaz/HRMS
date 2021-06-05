package kodlama.io.hrms.entities.concretes.cv;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cv_languages")
public class CvLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @JsonProperty(access = Access.WRITE_ONLY)
    @ManyToOne(targetEntity = Cv.class)
    @JsonIgnore()
    @JoinColumn(name = "cv_id")
    private Cv cv;
    
    @ManyToOne(targetEntity = Language.class)
	@JoinColumn(name="langauges_id")
	private Language language;
    
    
    public CvLanguage (Cv cv, Language language) {
		this.language = language;
		this.cv = cv;
	}
}
