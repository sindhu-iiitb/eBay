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

public class viewAction extends ActionSupport implements SessionAware, ModelDriven<viewmodel>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Map<String, Object> session = ActionContext.getContext().getSession();
    private viewmodel r = new viewmodel();
    viewService rs = new viewService();
   
    List<viewmodel> view = null;
   
    public List<viewmodel> getView() {
		return view;
	}
	public void setView(List<viewmodel> view) {
		this.view = view;
	}
	public String execute()
    {
        System.out.println("in view action");
        view=new ArrayList<viewmodel>();
      
        String user=(String) session.get("username");
        System.out.println("user in review item action is:"+user);
    	rs.viewService(r);
    	view=rs.getItemlist(user);
    	//System.out.println("Contents of cal: " + view.get(0).getGrandtotal());
    	//System.out.println("Contents of cal: " + view.get(0).getOrderdetails());
			
    	return "success";
    }
	@Override
	public viewmodel getModel() {
		// TODO Auto-generated method stub
		return r;
	}
	
	
	
	@Override
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		this.session=map;
		
	}
	
    
    
	
}