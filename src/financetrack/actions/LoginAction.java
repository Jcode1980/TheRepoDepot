package financetrack.actions;

import com.opensymphony.xwork2.ActionSupport;
 
public class LoginAction extends ActionSupport{
	private String username;
	private String password;
	private String message;
 
	public String authenticate() {
		System.out.println("authenticate");
		if (this.username.equals("admin")
				&& this.password.equals("admin")) {
			return "success";
		} else {
			
			addActionError(getText("error.login"));
                        //a function from ActionSupport, to get properties values from properties file
                        //we will explore this below.
			return "error";
		}
	}
 
	public String getUsername() {
		return username;
	}
 
	public void setUsername(String username) {
		this.username = username;
	}
 
	public String getPassword() {
		return password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMessage(){
		return message;
	}
	
	public void setMessage(String value){
		System.out.println("i am setting the message");
		message = value;
	}
	
}
