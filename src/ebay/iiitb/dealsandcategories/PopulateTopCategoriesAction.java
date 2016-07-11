package ebay.iiitb.dealsandcategories;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PopulateTopCategoriesAction extends ActionSupport implements ModelDriven<PopulateTopCategoriesModel>{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PopulateTopCategoriesModel subCategories;
	public PopulateTopCategoriesModel getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(PopulateTopCategoriesModel subCategories) {
		this.subCategories = subCategories;
	}

	private String category_Name = null;
	//ArrayList<String> subCategories = new ArrayList<String>();
	
	
	
	public String execute()
	{
		PopulateTopCategoriesService populateDealsService = new PopulateTopCategoriesService(getCategory_Name());
		System.out.println(getCategory_Name());
		subCategories = populateDealsService.getSubCategories();
		System.out.println(subCategories.subCatlist.get(0));
		return SUCCESS;
		
	}
	
	public String getCategory_Name() {
		return category_Name;
	}
	public void setCategory_Name(String category_Name) {
		this.category_Name = category_Name;
	}

	@Override
	public PopulateTopCategoriesModel getModel() {
		// TODO Auto-generated method stub
		return subCategories;
	}

	
}
