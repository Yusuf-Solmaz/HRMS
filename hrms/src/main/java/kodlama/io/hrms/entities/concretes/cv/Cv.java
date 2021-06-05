package kodlama.io.hrms.entities.concretes.cv;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlama.io.hrms.entities.concretes.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cvs")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
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

    @Column(name="photo_link")
	private String photoLink;
    
    @Column(name="is_active")
	private boolean isActive;
    
    @OneToMany(mappedBy = "cv", fetch = FetchType.LAZY)
    @JsonIgnore()
    private List<CvEducation> cvEducations;

    @OneToMany(mappedBy = "cv", fetch = FetchType.LAZY)
    @JsonIgnore()
    private List<CvExperience> cvExperiences;
    
    @OneToMany(mappedBy = "cv", fetch = FetchType.LAZY)
    @JsonIgnore()
    private List<CvLanguage> cvLanguages;
    
    @OneToMany(mappedBy = "cv", fetch = FetchType.LAZY)
    @JsonIgnore()
    private List<CvSkill> cvSkills;
    
    @ManyToOne()
    @JoinColumn(name = "job_seeker_ıd")
    private JobSeeker jobSeeker;

}
