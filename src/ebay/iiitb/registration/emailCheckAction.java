package ebay.iiitb.registration;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * @author sindhu
 * Registration Action
 *
 */
public class emailCheckAction extends ActionSupport {

	
	
	boolean status;
	String email_first;
	String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail_first() {
		return email_first;
	}

	public void setEmail_first(String email_first) {
		this.email_first = email_first;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}



	
	
	RegistrationService registrationService=new RegistrationService();
	
	public String execute() {
		
		 setUsername(registrationService.checkEmailService(getEmail_first()));	
		 System.out.println(isStatus());
	
		return SUCCESS;
	}

//	@Override
//	public RegistrationModel getModel() {
//		// TODO Auto-generated method stub
//		return registrationModel;
//	}

}
