package ebay.iiitb.Payment;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PaymentPageAction extends ActionSupport implements ModelDriven<PaymentModel>,SessionAware
{
	/**
	 * 
	 */
	Map<String, Object> session = ActionContext.getContext().getSession();
	private static final long serialVersionUID = 1L;
	PaymentModel paymentModel=new PaymentModel();
	PaymentPageService paymentPageService=new PaymentPageService(paymentModel);
	@Override
	public PaymentModel getModel() {
		// TODO Auto-generated method stub
		return paymentModel;
	}
	public String execute()
	{
		 String user=(String) session.get("email");
		 String cardid=(String) session.get("cardid");
	     System.out.println("user in paymentpageaction item action is:"+user+" "+cardid);
		System.out.println("in action");
		if(paymentPageService.PaymentPageMethod(user,cardid).equals("true"))
		{
			System.out.println("in actioniftrue");
				return "success";
		}
		else if(paymentPageService.PaymentPageMethod(user,cardid).equals("false"))
			{
				System.out.println("in actionif.......");
					return ERROR;
			}
			
		else 
			return "NoBal";
		
	}
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		this.session=map;
		
	}
	

	
}
