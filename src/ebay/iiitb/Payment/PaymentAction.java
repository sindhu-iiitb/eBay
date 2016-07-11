package ebay.iiitb.Payment;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PaymentAction extends ActionSupport implements ModelDriven<PaymentModel>,SessionAware
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PaymentModel paymentModel=new PaymentModel();
	PaymentService paymentService=new PaymentService(paymentModel);
	private Map<String, Object> session;
	@Override
	public PaymentModel getModel() {
		// TODO Auto-generated method stub
		return paymentModel;
	}
	 public void validate() 
	 {
		 if(paymentModel.getDebit_Card().isEmpty())
	 {
			 addFieldError("Debit_Card", "id cannot be blank");
		 }
		 if(paymentModel.getPassword().isEmpty())
		 {
			 addFieldError("Password", "password cannot be blank");
		 }		 
    }
		public String execute()
		{
			System.out.println("in payment acton action");
			if(paymentService.PaymentMethod())
			{
				session.put("cardid",paymentModel.getDebit_Card());
				session.put("pass",paymentModel.getPassword());
				System.out.println(session.get("cardid"));;
					
						return "success";
			}
			else
				{
					
						return ERROR;
				}

			
		}
		@Override
		public void setSession(Map<String, Object> map) {
			
			this.session=map;
		}

}
