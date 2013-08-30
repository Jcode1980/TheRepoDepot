package financetrack.actions;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;



public class HelloWorldAction extends ActionSupport {
	private Map<String, Object> userSession ;

	private static final long serialVersionUID = 1L;


	public String execute() throws Exception {
		
		//messageStore = new MessageStore() ;
		return SUCCESS;
	}
	
	public void setSession(Map<String,Object> session){
		userSession = session ;
	}
}

/*

public interface Action {
   public static final String SUCCESS = "success";
   public static final String NONE = "none";
   public static final String ERROR = "error";
   public static final String INPUT = "input";
   public static final String LOGIN = "login";
   public String execute() throws Exception;
}


*/
