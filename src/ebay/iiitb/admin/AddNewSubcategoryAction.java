package ebay.iiitb.admin;



import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddNewSubcategoryAction extends ActionSupport implements ModelDriven<AddNewSubcategoryModel>{
	AddNewSubcategoryModel addNewSubcategoryModel=new AddNewSubcategoryModel();
	AddNewSubcategoryService addNewSubcategoryService=new AddNewSubcategoryService(addNewSubcategoryModel);
	
	
	public AddNewSubcategoryModel getAddNewSubcategoryModel() {
		return addNewSubcategoryModel;
	}

	

	public void validate() {
		 if(addNewSubcategoryModel.getSubcategory().isEmpty())
	 {
			 addFieldError("subcategory", "subcategory cannot be blank");
		 }
		
		
		 
   }
	
	public void setAddNewSubcategoryModel(AddNewSubcategoryModel addNewSubcategoryModel) {
		this.addNewSubcategoryModel = addNewSubcategoryModel;
	}

	public String execute()
	{
		if(addNewSubcategoryService.addSubcategory())
		{
			return SUCCESS;
		}
		else {
			return ERROR;
		}
		
	}
	@Override
	public AddNewSubcategoryModel getModel() {
		// TODO Auto-generated method stub
		return addNewSubcategoryModel;
	}
	
	

}
