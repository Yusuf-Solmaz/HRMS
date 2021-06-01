package kodlama.io.hrms.entities.concretes;

import java.sql.Date;   


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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="job_advertisements")
@Data
@EqualsAndHashCode(callSuper=false)

@NoArgsConstructor

public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_advertisement_id")
	private int jobAdvertisementId;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="open_positions")
	private Integer openPosition;
	
	@Column(name="advertisement_deathline")
	private Date advertisementDeadline;
	
	@Column(name="creation_date")
	private java.util.Date creationDate;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="min_salary")
	private int minSalary;
	
    @ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
    @ManyToOne()
    @JoinColumn(name="job_position_id")
    private JobPosition jobPosition;

    @ManyToOne()
    @JoinColumn(name="employer_id")
    private Employer employer;

	public JobAdvertisement(int jobAdvertisementId, String jobDescription, Integer openPosition,
			Date advertisementDeadline, java.util.Date creationDate, boolean isActive, int maxSalary, int minSalary,
			City city, JobPosition jobPosition, Employer employer) {
		super();
		this.jobAdvertisementId = jobAdvertisementId;
		this.jobDescription = jobDescription;
		this.openPosition = openPosition;
		this.advertisementDeadline = advertisementDeadline;
		this.creationDate = creationDate;
		this.isActive = isActive;
		this.maxSalary = maxSalary;
		this.minSalary = minSalary;
		this.city = city;
		this.jobPosition = jobPosition;
		this.employer = employer;
	}
	
    
}
