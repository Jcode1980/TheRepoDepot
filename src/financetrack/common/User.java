package financetrack.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User {
	private long userID;
	private String login;
	private String given;
	private String surname;
	private String email;
	
	@Column(name="login")
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	@Column(name="given")
	public String getGiven() {
		return given;
	}

	public void setGiven(String given) {
		this.given = given;
	}
	
	@Column(name="surname")
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	@Column(name="surname")
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	public long getUserID() {
		return userID;
	}

	/**
	 * Set userID
	 * 
	 * @param userID
	 */
	@SuppressWarnings("unused")
	private void setUserID(long userID) {
		this.userID = userID;
	}
	
	
}
