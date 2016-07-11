package ebay.iiitb.PopulateItems;

import java.util.ArrayList;
import java.util.List;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SubCategoryAction extends ActionSupport  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ItemModel> subCategoryItems;
	private ArrayList<ItemModel> advtitems;
	private ArrayList<ArrayList<ItemModel>> nestedsubcategory;
	private ArrayList<String> brands;
	
	public ArrayList<ItemModel> getSubCategoryItems() {
		return subCategoryItems;
	}
	
	public void setSubCategoryItems(ArrayList<ItemModel> subCategoryItems) {
		this.subCategoryItems = subCategoryItems;
	}
	
	
	
	private String category_Name = null;
	public ArrayList<ArrayList<ItemModel>> getNestedsubcategory() {
		return nestedsubcategory;
	}
	public void setNestedsubcategory(ArrayList<ArrayList<ItemModel>> nestedsubcategory) {
		this.nestedsubcategory = nestedsubcategory;
	}

	private String name = category_Name;
	
	SubCategoryService subCategoryService = new SubCategoryService();
//	public String getSubCategoryItems()
//	{
//		
//		return SUCCESS;
//	}
	public String execute()
	{
		 System.out.println("In Execute");
		setNestedsubcategory(subCategoryService.DisplaySubCategories(getCategory_Name()));
		setBrands(subCategoryService.getBrands());
		System.out.println(getBrands());
	/*	for (ItemModel itemModel : subCategoryItems) {
			System.out.println(itemModel.getItem_Id());
		}*/
		return SUCCESS;
	}
	public ArrayList<ItemModel> getAdvtitems() {
		return advtitems;
	}
	public void setAdvtitems(ArrayList<ItemModel> advtitems) {
		this.advtitems = advtitems;
	}
	
/*	public ArrayList<ItemModel> getModel() {
		
		return subCategoryItems;
	}*/
	//@Override
//public ArrayList<ArrayList<ItemModel>> getModel() {
		
	//	return nestedsubcategory;
	//}

	public String getCategory_Name() {
		return category_Name;
	}
	

	public void setCategory_Name(String category_Name) {
		this.category_Name = category_Name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getBrands() {
		return brands;
	}

	public void setBrands(ArrayList<String> brands) {
		this.brands = brands;
	}

}
