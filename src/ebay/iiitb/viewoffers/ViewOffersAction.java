package ebay.iiitb.viewoffers;

import java.util.ArrayList;
import com.opensymphony.xwork2.ActionSupport;



public class ViewOffersAction extends ActionSupport {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9038159308424518719L;
	ArrayList<ViewOffersModel> offersModels=new ArrayList<ViewOffersModel>();
	public ArrayList<ViewOffersModel> getOffersModels() {
		return offersModels;
	}
	public void setOffersModels(ArrayList<ViewOffersModel> offersModels) {
		this.offersModels = offersModels;
	}
	public String execute()
	{
		System.out.println("In view action");
		ViewOffersService viewOffersService=new ViewOffersService();
		setOffersModels(viewOffersService.viewOffers());
		return SUCCESS;
	}
//	@Override
//	public ArrayList<ViewOffersModel> getModel() {
//		// TODO Auto-generated method stub
//		return offersModels;
//	}
	
	
}
