package ebay.iiitb.infoupdate;
import java.sql.Connection; 
import ebay.iiitb.*;

import ebay.iiitb.DBUtil.*;


import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import java.util.*;

public class changepasswordAction extends ActionSupport implements SessionAware {

	Map<String, Object> session = ActionContext.getContext().getSession();
	private String newpass;
	changepasswordService x = new changepasswordService();
	boolean status;
	@Override
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		this.session=map;
	}
	
public String getNewpass() {
		return newpass;
	}

	public void setNewpass(String newpass) {
		this.newpass = newpass;
	}

public String execute()
{
 System.out.println("new password is:"+getNewpass());
 String user=(String) session.get("username");
 System.out.println("user in change password action is:"+user);
 status = x.updateinfo(user,newpass);
 return "success";

}
}