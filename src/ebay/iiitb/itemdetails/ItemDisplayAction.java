package ebay.iiitb.itemdetails;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ItemDisplayAction extends ActionSupport implements ModelDriven<ItemModel>{

	ItemModel item=new ItemModel();
	ItemDisplayService itemDisplayService=new ItemDisplayService();
	
	public ItemModel getItem() {
		return item;
	}


	public void setItem(ItemModel item) {
		this.item = item;
	}

	public String execute(){
		
		if(itemDisplayService.itemdetails(item))
		return SUCCESS;
		else
		return ERROR;
		
	}

	@Override
	public ItemModel getModel() {
		// TODO Auto-generated method stub
		return item;
	}
	

}
