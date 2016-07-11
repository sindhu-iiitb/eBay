package entryAction;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class EntryAction extends ActionSupport{
	
	public String execute()
    {
		System.out.println("in entry action");
        return "success";
    }
}
