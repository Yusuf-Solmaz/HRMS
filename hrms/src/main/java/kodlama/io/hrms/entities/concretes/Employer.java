package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.Table;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Table(name="employers")
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class Employer extends User{

	
	
	@Column(name="company_name") 
	private String companyName;
	
	@Column(name="phone_number") 
	private String phoneNumber;
	
	@Column(name="web_site") 
	private String webSite;
	
	@Column(name="verify_system") 
	private boolean verifySystem;

	public Employer(String mail, String password, boolean confirm, String companyName, String phoneNumber, String webSite, boolean verifySystem) {
		super(mail, password, confirm);
		this.companyName = companyName;
		this.phoneNumber = phoneNumber;
		this.webSite = webSite;
		this.verifySystem = verifySystem;
	}
	
}
