package ebay.iiitb.interceptor;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;
public class AuthenticationInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		Map<String, Object> session = ActionContext.getContext()
				.getSession();
		String email;
		email = (String) session.get("email");
		System.out.println("In Authen" + " " +session.get("email"));
		System.out.println("In Authentication" +  " " + session.get("user_surr_key"));
		if(email == null)
		{
			return ActionSupport.LOGIN;
		}
		return actionInvocation.invoke();
	}
	
	


}
