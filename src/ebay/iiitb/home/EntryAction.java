package ebay.iiitb.home;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import ebay.iiitb.PopulateItems.ItemModel;
import ebay.iiitb.PopulateItems.SubCategoryService;

public class EntryAction extends ActionSupport {
	
	private Map<String,ArrayList<CategoryModel>> categories;
	private ArrayList<ItemModel> advtitems;
	
	
	

	public ArrayList<ItemModel> getAdvtitems() {
		return advtitems;
	}

	public void setAdvtitems(ArrayList<ItemModel> advtitems) {
		this.advtitems = advtitems;
	}

	public DisplayCategoriesService getDisplayCategoriesService() {
		return displayCategoriesService;
	}

	public void setDisplayCategoriesService(DisplayCategoriesService displayCategoriesService) {
		this.displayCategoriesService = displayCategoriesService;
	}

	DisplayCategoriesService displayCategoriesService = new DisplayCategoriesService();
	SubCategoryService subCategoryService=new SubCategoryService();
	
	public String execute()	{
		categories = displayCategoriesService.displayCategories();
		for (Iterator<String> iterator = categories.keySet().iterator(); iterator.hasNext();) { 
			ArrayList<CategoryModel> subcategories = (ArrayList<CategoryModel>) categories.get(iterator.next());
			for (Iterator<CategoryModel> subiterator = subcategories.iterator(); subiterator.hasNext();) {
				CategoryModel categoryModel = (CategoryModel) subiterator.next();
//				System.out.println(categoryModel.getCategory_Name());
			}
			
		}
		setAdvtitems(subCategoryService.DisplayAdvt());
		System.out.println(advtitems.get(3).getItem_Name());
		return SUCCESS;
	}

	public Map<String,ArrayList<CategoryModel>> getCategories() {
		return categories;
	}

	public void setCategories(Map<String,ArrayList<CategoryModel>> categories) {
		this.categories = categories;
	}
	


}
