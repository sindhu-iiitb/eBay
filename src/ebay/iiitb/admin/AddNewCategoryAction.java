package ebay.iiitb.admin;



import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddNewCategoryAction extends ActionSupport implements ModelDriven<AddNewCategoryModel>{

	AddNewCategoryModel addNewCategoryModel = new AddNewCategoryModel();
	AddNewCategoryService addNewCategoryService = new AddNewCategoryService(addNewCategoryModel);
	public AddNewCategoryModel getAddNewCategoryModel() {
		return addNewCategoryModel;
	}
	public void setAddNewCategoryModel(AddNewCategoryModel addNewCategoryModel) {
		this.addNewCategoryModel = addNewCategoryModel;
	}
//	
//	public void validate() {
//		 if(addNewCategoryModel.getCategory().isEmpty())
//	 {
//			 addFieldError("category", "category cannot be blank");
//		 }
//		
//		
//		 
//   }
	
	
	
	public String execute()
	{
		if(addNewCategoryService.addCategory())
			return SUCCESS;
		else
			return ERROR;
	}
	@Override
	public AddNewCategoryModel getModel() {
		// TODO Auto-generated method stub
		return addNewCategoryModel;
	}

}