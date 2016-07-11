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

public class deleteAction extends ActionSupport implements SessionAware {

	Map<String, Object> session = ActionContext.getContext().getSession();
	
	deleteService x = new deleteService();
	boolean status,status1,status2,status3;
	int userid;
	@Override
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		this.session=map;
	}
	



public String execute()
{
 
 String user=(String) session.get("username");
 System.out.println("user in change password action is:"+user);
 userid=x.getuserid(user);
 status = x.deleteuser(user,userid);
 status1=x.deleteaddress(user,userid);
 status2=x.deleteselleritems(user,userid);
 status3=x.deleteseller(user,userid);
 
 return "success";

}
}