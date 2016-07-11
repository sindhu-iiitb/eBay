package ebay.iiitb.PopulateItems;


import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;


public class PopulateSubCategoriesAction extends ActionSupport{


	String category_Name;
	String subcatid;
	ArrayList<String> brands=new ArrayList<String>();
	ArrayList<ItemModel> items = new ArrayList<ItemModel>(); 
	
	
	public ArrayList<String> getBrands() {
		return brands;
	}


	public void setBrands(ArrayList<String> brands) {
		this.brands = brands;
	}

	public String getSubcatid() {
		return subcatid;
	}


	public void setSubcatid(String subcatid) {
		this.subcatid = subcatid;
	}


	public String getCategory_Name() {
		return category_Name;
	}


	public void setCategory_Name(String category_Name) {
		this.category_Name = category_Name;
	}


	
	
	public ArrayList<ItemModel> getItems() {
		return items;
	}


	public void setItems(ArrayList<ItemModel> items) {
		this.items = items;
	}




	public String execute(){
		System.out.println("In Subcategory click action");
		System.out.println(getCategory_Name());
		PopulateSubCategoriesService service = new PopulateSubCategoriesService();
		System.out.println("subcat id:" + getCategory_Name());
		items = service.getAllItems(getCategory_Name());
		setSubcatid(service.getSubCatId(getCategory_Name()));
		setBrands(service.getBrands(category_Name));
		if(items.isEmpty())
			return ERROR;
		else {
			return SUCCESS;
		}
		
	}
	
}

