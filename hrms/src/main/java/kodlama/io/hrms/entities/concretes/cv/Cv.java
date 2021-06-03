package kodlama.io.hrms.entities.concretes.cv;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cvs")
@Entity
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "github_link")
    private String github;

    @Column(name = "linkedin_link")
    private String linkedin;

    @OneToMany(mappedBy = "cv")
    @JsonIgnore()
    private List<CvEducation> cvEducations;

    @OneToMany(mappedBy = "cv")
    @JsonIgnore()
    private List<CvExperience> cvExperiences;
    
    @OneToMany(mappedBy = "cv")
    @JsonIgnore()
    private List<CvLanguage> cvLanguages;
    
    @OneToMany(mappedBy = "cv")
    @JsonIgnore()
    private List<CvSkill> cvSkills;

}
