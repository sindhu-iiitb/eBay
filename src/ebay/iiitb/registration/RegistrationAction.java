package ebay.iiitb.registration;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * @author sindhu
 * Registration Action
 *
 */
public class RegistrationAction extends ActionSupport implements ModelDriven<RegistrationModel>{

	RegistrationModel registrationModel=new RegistrationModel();

	public RegistrationModel getRegistrationModel() {
		return registrationModel;
	}

	public void setRegistrationModel(RegistrationModel registrationModel) {
		this.registrationModel = registrationModel;
	}
	
	RegistrationService registrationService=new RegistrationService();
	
	public String execute() {
		System.out.println(registrationModel);
		boolean status=registrationService.register(registrationModel);	
		
		if(status)
			return SUCCESS;
		
		else
			return ERROR;
	}

	@Override
	public RegistrationModel getModel() {
		// TODO Auto-generated method stub
		return registrationModel;
	}

}
