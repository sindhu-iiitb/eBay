package ebay.iiitb.admin;

import com.opensymphony.xwork2.ActionSupport;


public class ChangeVatPercentageAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	int vat_percentage;
	
	public int getVat_percentage() {
		return vat_percentage;
	}

	public void setVat_percentage(int vat_percentage) {
		this.vat_percentage = vat_percentage;
	}
	
	public String execute()
	{
		ChangeVatPercentageService changeVatPercentageService = new ChangeVatPercentageService(getVat_percentage());
		System.out.println(getVat_percentage());
		if(changeVatPercentageService.updateVatdetails())
		return SUCCESS;
		else
		return ERROR;
	}
	
	
	
}
