package ebay.iiitb.home;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;




public class HeaderAction extends ActionSupport{
	private Map<String,ArrayList<CategoryModel>> categories;
	public DisplayCategoriesService getDisplayCategoriesService() {
		return displayCategoriesService;
	}

	public void setDisplayCategoriesService(DisplayCategoriesService displayCategoriesService) {
		this.displayCategoriesService = displayCategoriesService;
	}

	DisplayCategoriesService displayCategoriesService = new DisplayCategoriesService();
	
	public String execute()	{
		categories = displayCategoriesService.displayCategories();
		for (Iterator<String> iterator = categories.keySet().iterator(); iterator.hasNext();) { 
			ArrayList<CategoryModel> subcategories = (ArrayList<CategoryModel>) categories.get(iterator.next());
			for (Iterator<CategoryModel> subiterator = subcategories.iterator(); subiterator.hasNext();) {
				CategoryModel categoryModel = (CategoryModel) subiterator.next();
//				System.out.println(categoryModel.getCategory_Name());
			}
			
		}
		System.out.println("out of header");
		return SUCCESS;
	}

	public Map<String,ArrayList<CategoryModel>> getCategories() {
		return categories;
	}

	public void setCategories(Map<String,ArrayList<CategoryModel>> categories) {
		this.categories = categories;
	}
	


}
