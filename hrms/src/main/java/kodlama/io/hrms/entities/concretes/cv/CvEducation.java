package kodlama.io.hrms.entities.concretes.cv;


import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cv_educations")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
public class CvEducation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "school_name")    
    private String schoolName;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "start_year")
    private Date startYear;

    @Column(name = "graduation_year")
    private Date graduationYear;
    
    @Column(name="is_graduated")
    private boolean isGraduated;
    
    @ManyToOne(targetEntity = Cv.class)
    @JsonIgnore()
    @JoinColumn(name="cv_id")
    private Cv cv;
}
