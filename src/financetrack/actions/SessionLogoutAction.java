package financetrack.actions;

import java.util.Map;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.*;

public class SessionLogoutAction extends ActionSupport {

    public String execute() throws Exception { 
     Map session = ActionContext.getContext().getSession();
session.remove("logined"); 
session.remove("context");
        return SUCCESS;
    }

}
