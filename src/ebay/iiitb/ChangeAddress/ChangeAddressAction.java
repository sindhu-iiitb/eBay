package ebay.iiitb.ChangeAddress;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ChangeAddressAction extends ActionSupport implements ModelDriven<ChangeAddressModel>,SessionAware
{

	private static final long serialVersionUID = 1L;
	@Override
	public ChangeAddressModel getModel() 
	{
			return changeAddressModel;
	}
	ChangeAddressModel changeAddressModel=new ChangeAddressModel();
	ChangeAddressService changeAddressService=new ChangeAddressService(changeAddressModel);
	Map<String, Object> session = ActionContext.getContext().getSession();
	
    public String execute()
	{
    	int u_surkey = (Integer) session.get("user_surr_key");
		System.out.println("in action change");
		System.out.println(session.get("email"));
		System.out.println("in ChangeAddressaction user "+session.get("email"));
		System.out.println("in ChangeAddressaction2 user "+session.get("email"));
		System.out.println("in action23ChangeAddress");
		String user=(String)session.get("email");
		System.out.println("user in action is:"+user);
		if(changeAddressService.ChangeAddressMethod(user,u_surkey))
		{			
				return "success";
		}
		else
			return ERROR;			
	}
	

	public void setSession(Map<String, Object> map) 
	{
		this.session=map;
	}

}
