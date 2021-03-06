package kodlama.io.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;    
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="job_advertisements")
@Data
//@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor

public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_advertisement_id")
	private int jobAdvertisementId;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="open_positions")
	private Integer openPosition;
	
	@Column(name="advertisement_deadline")
	private LocalDate advertisementDeadline;
	
	@Column(name="is_active",columnDefinition = "boolean default true")
	private boolean isActive;
	
	@Column(name="creation_date")
	private LocalDate creationDate;
	
	
	@ManyToOne()
    @JoinColumn(name="employer_id")
    private Employer employer;
	
    @ManyToOne()
    @JoinColumn(name="job_position_id")
    private JobPosition jobPosition;

    
    @ManyToOne()
	@JoinColumn(name="city_id")
	private City city;

    @ManyToOne()
  	@JoinColumn(name = "type_of_working_id")
  	private TypeOfWorking typeOfWorking;
      
      @ManyToOne
  	@JoinColumn(name = "way_of_working_id")
  	private WayOfWorking wayOfWorking;

    
}
