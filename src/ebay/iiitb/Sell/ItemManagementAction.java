package ebay.iiitb.Sell;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ItemManagementAction extends ActionSupport implements ModelDriven<ItemActionModel>,SessionAware
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ItemActionModel itemAction = new ItemActionModel();
	private Map<String,ArrayList<CategoryModel>> categories;
	private String category_Name;
	private String subCategory_Name;
	DisplayCategoriesService displayCategoriesService = new DisplayCategoriesService();
	private Map<String, Object> session;

	
	public String execute()
	{
			if(session.keySet().size() != 0)
			{
			System.out.println("inside ItemManagement");
			setCategories(displayCategoriesService.displayCategories());
			System.out.println("__________"+categories.keySet());
			return "success";
			}
		
		return "error";
		
	}

	@Override
	public ItemActionModel getModel() {
		
		return itemAction;
	}

	public String getCategory_Name() {
		return category_Name;
	}

	public void setCategory_Name(String category_Name) {
		this.category_Name = category_Name;
	}

	public String getSubCategory_Name() {
		return subCategory_Name;
	}

	public void setSubCategory_Name(String subCategory_Name) {
		this.subCategory_Name = subCategory_Name;
	}

	public Map<String,ArrayList<CategoryModel>> getCategories() {
		return categories;
	}

	public void setCategories(Map<String,ArrayList<CategoryModel>> categories) {
		this.categories = categories;
	}

	@Override
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		this.session=map;
		
	}

}
