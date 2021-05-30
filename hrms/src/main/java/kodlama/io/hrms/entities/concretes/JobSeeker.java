package kodlama.io.hrms.entities.concretes;

import java.sql.Date;    

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@PrimaryKeyJoinColumn(name="id",referencedColumnName = "id")
@Entity
@Table(name="job_seekers")
@Data
@EqualsAndHashCode(callSuper=false)

@NoArgsConstructor
public class JobSeeker extends User{

	
	
	@Column(name="nationality_id") 
	private String nationalityId;
	
	@Column(name="first_name") 
	private String firstName;
	
	@Column(name="last_name") 
	private String lastName;
	
	@Column(name="birth_date") 
	private Date birthDate;


	
	public JobSeeker( String mail, String password, boolean confirm, String nationalityId, String firstName,
			String lastName, Date birthDate ) {
		super( mail, password, confirm);
		this.nationalityId = nationalityId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		
	}
	
	
}
