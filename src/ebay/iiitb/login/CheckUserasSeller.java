package ebay.iiitb.login;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CheckUserasSeller extends ActionSupport implements SessionAware {
	private Map<String, Object> session;

	public String execute(){
		System.out.println("in seller");
		System.out.println(session.get("email"));
		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> map) {
		
		this.session=map;
	}

}
