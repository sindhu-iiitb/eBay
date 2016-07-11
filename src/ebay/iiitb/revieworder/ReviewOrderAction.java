package ebay.iiitb.revieworder;

import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;
import java.util.Map;


public class ReviewOrderAction extends ActionSupport implements SessionAware{

	
	private static final long serialVersionUID = 1L;
	
	Map<String, Object> session = ActionContext.getContext().getSession();
	 private int grandtotal;
   
    
   
    List<Reviewmodel> TL = null;
    public List<Reviewmodel> getTL() {
        return TL;
    }
    public void setList(List<Reviewmodel> TL) {
        this.TL = TL;
    }
    public String execute()
    {
        System.out.println("in action");
        ReviewService rs = new ReviewService();
        TL=new ArrayList<Reviewmodel>();
       
        String user=(String) session.get("email");
        System.out.println("user in action is:"+user);
    	
    	TL=rs.getAddress(user);
    	if(getGrandtotal()>0)
    		session.put("grandtotal", getGrandtotal());
    	else
    		setGrandtotal((Integer)session.get("grandtotal"));
			
    	if(TL.size() > 0)
    	{
    		System.out.println("Success returned");
    		TL.get(0).setStatus(1);
    		return "success";
    		
    	}
    	else
    	{
    		System.out.println("error returned");
    		Reviewmodel reviewmodel = new Reviewmodel();
    		TL.add(reviewmodel);
    		TL.get(0).setStatus(0);
    		return "error";
    	}
    	
    	
    }
    
	@Override
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		this.session=map;
	}
	public int getGrandtotal() {
		return grandtotal;
	}
	public void setGrandtotal(int grandtotal) {
		this.grandtotal = grandtotal;
	}
}
