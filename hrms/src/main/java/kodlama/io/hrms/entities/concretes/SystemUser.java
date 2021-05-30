package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;  
import javax.persistence.Entity;

import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name="system_users")
@AllArgsConstructor
@NoArgsConstructor
public class SystemUser extends User {

	
	
	@Column(name="first_name") 
	private String firstName;
	
	@Column(name="last_name") 
	private String lastName;
}
