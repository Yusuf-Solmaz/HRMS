package kodlama.io.hrms.entities.concretes.cv;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cv_educations")
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
    private int startYear;

    @Column(name = "graduation_year")
    private int graduationYear;
    
    @ManyToOne()
    @JsonIgnore()
    @JoinColumn(name="cv_id")
    private Cv cv;
}
