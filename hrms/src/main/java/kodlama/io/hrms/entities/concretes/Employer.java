package kodlama.io.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;   
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
 

@Entity
@Table(name="employers")
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class Employer extends User{

	
	
	@Column(name="company_name") 
	private String companyName;
	
	@Column(name="phone_number") 
	private String phoneNumber;
	
	@Column(name="web_site") 
	private String webSite;
	
	@Column(name="verify_system") 
	private boolean verifySystem;

	@Autowired
	public Employer(String webSite, String password, boolean confirm, String companyName, String phoneNumber, String mail, boolean verifySystem) {
		super(mail, password, confirm);
		this.companyName = companyName;
		this.phoneNumber = phoneNumber;
		this.webSite = webSite;
		this.verifySystem = verifySystem;
	}
	
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;
	
}
