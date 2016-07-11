package ebay.iiitb.itemmanage;

import java.sql.Connection;
import java.util.Map;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;

import ebay.iiitb.DBUtil.DbConnection;

public class sessionservice implements SessionAware{
	//HttpSession session = ServletActionContext.getRequest().getSession();
	DbConnection db=new DbConnection();
	Connection con =db.getConnection();
	private Map<String, Object> session;
	
	

	
	
	public String show()
	{
	String email=(String) ((ActionContext) session).get("email");
	System.out.println(email+"as logged in sessionservice---------------------");
	return email;
	}




	@Override
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		this.session=map;
		
	}
	
	
}
