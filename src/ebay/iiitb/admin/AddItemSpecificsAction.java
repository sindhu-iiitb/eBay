package ebay.iiitb.admin;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddItemSpecificsAction extends ActionSupport implements ModelDriven<AddItemSpecificAttributeModel>{

	AddItemSpecificAttributeModel addItemSpecificAttributeModel=new AddItemSpecificAttributeModel();
	
	
	public AddItemSpecificAttributeModel getAddItemSpecificAttributeModel() {
		return addItemSpecificAttributeModel;
	}

	public void setAddItemSpecificAttributeModel(AddItemSpecificAttributeModel addItemSpecificAttributeModel) {
		this.addItemSpecificAttributeModel = addItemSpecificAttributeModel;
	}
	
	
	public String execute(){
		AddItemSpecificsService addItemSpecificsService=new AddItemSpecificsService();
		System.out.println(addItemSpecificAttributeModel);
		if(addItemSpecificsService.addItemspecs(addItemSpecificAttributeModel))
		return SUCCESS;
		else
			return ERROR;
	}

	@Override
	public AddItemSpecificAttributeModel getModel() {
		// TODO Auto-generated method stub
		return addItemSpecificAttributeModel;
	}


	
	
}
