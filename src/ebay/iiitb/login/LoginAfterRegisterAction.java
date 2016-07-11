package ebay.iiitb.login;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAfterRegisterAction extends ActionSupport implements SessionAware,ModelDriven<LoginModal> {

	private Map<String,Object> session=null;
	LoginService loginService=new LoginService();
	LoginModal loginModal=new LoginModal();
	
	public LoginModal getLoginModal() {
		return loginModal;
	}


	public void setLoginModal(LoginModal loginModal) {
		this.loginModal = loginModal;
	}


	public String execute() {
		if(loginService.loginafterregister(loginModal))
		{
		session.put("email", loginModal.getEmail_user());
		session.put("username", loginModal.getUsername());
		session.put("fname",loginModal.getFname());
		session.put("lname",loginModal.getLname());
		session.put("user_surr_key", loginModal.getU_surkey());	
		return SUCCESS;
		}
		else {
			System.out.println("in else");
			return ERROR;
		}
	}
	
	
	@Override
	public LoginModal getModel() {
		// TODO Auto-generated method stub
		return loginModal;
	}
	

	@Override
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		this.session=map;
	}

}
