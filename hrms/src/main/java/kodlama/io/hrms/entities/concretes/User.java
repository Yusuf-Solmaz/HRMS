package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;     
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance; 
import javax.persistence.InheritanceType;
import javax.persistence.Table;


import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@Inheritance (strategy = InheritanceType.JOINED)
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	
	@Column(name="mail") 
	private String mail;
	
	@Column(name="password") 
	private String password;
	
	@Column(name="confirm") 
	private boolean confirm;

	public User(String mail, String password, boolean confirm) {
		super();
		this.mail = mail;
		this.password = password;
		this.confirm = confirm;
	}
	//deneme
}
