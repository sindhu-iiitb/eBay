package ebay.iiitb.PopulateItems;

import java.util.ArrayList;
import java.util.Iterator;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import ebay.iiitb.dealsandcategories.PopulateTopCategoriesModel;

public class PopulateItemsAction extends ActionSupport implements ModelDriven<PopulateItemsModel>{

	static PopulateItemsModel populateItemsModel;
	public PopulateItemsModel getPopulateItemsModel() {
		return populateItemsModel;
	}

	public void getPopulateItemsModel(PopulateItemsModel populateItemsModel) {
		this.populateItemsModel = populateItemsModel;
	}
	
	private String subcategory_Name = null;
	//ArrayList<String> subCategories = new ArrayList<String>();
	
	
	
	public String execute()
	{
		PopulateItemsService populateItemsService = new PopulateItemsService(getSubcategory_Name());
		//System.out.println(getSubcategory_Name());
		populateItemsModel= populateItemsService.getPopulateItemsModel();
		System.out.println("In Model");
		System.out.println(populateItemsModel.getItemList());
		
		return SUCCESS;
		
		
	}
	
	public String getSubcategory_Name() {
		return subcategory_Name;
	}
	public void setSubcategory_Name(String category_Name) {
		this.subcategory_Name = subcategory_Name;
	}

	@Override
	public PopulateItemsModel getModel() {
		// TODO Auto-generated method stub
		return populateItemsModel;
	}

	
}
