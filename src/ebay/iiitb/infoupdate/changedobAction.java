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

public class changedobAction extends ActionSupport implements SessionAware {

	Map<String, Object> session = ActionContext.getContext().getSession();
	private String newdob;
	changedobService x = new changedobService();
	boolean status;
	@Override
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		this.session=map;
	}
	


public String getNewdob() {
		return newdob;
	}



	public void setNewdob(String newdob) {
		this.newdob = newdob;
	}



public String execute() throws Exception
{
 System.out.println("new date is:"+getNewdob());
 String user=(String) session.get("username");
 System.out.println("user in change password action is:"+user);
 status = x.updateinfo(user,getNewdob());
 return "success";

}
}