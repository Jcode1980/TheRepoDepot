package financetrack.actions;
import java.util.ArrayList;
import java.util.Date;import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SessionLoginAction extends BaseAssetListAction {
	private String userId;
    private String passwd;
    

    public String execute() throws Exception {
        if ("admin".equals(userId) && "password".equals(passwd)) {
//          HttpSession session = ServletActionContext.getRequest().getSession();
//          session.setAttribute("logined","true");
//          session.setAttribute("context", new Date());
// 			Better is using ActionContext 
        	Map session = ActionContext.getContext().getSession();
        	session.put("logined","true");
            session.put("context", new Date());
            return SUCCESS;
        }
        return ERROR;
    }

    public String logout() throws Exception {
//      HttpSession session = ServletActionContext.getRequest().getSession();
//      session.removeAttribute("logined");
//      session.removeAttribute("context"); 
    	Map session = ActionContext.getContext().getSession();
    	session.remove("logined");
        session.remove("context");
        return SUCCESS;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
   

}