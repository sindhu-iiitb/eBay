package ebay.iiitb.Sell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ebay.iiitb.DBUtil.DbConnection;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SellItemAction extends ActionSupport implements ModelDriven<SellItemModel>{

	private SellItemModel itemModel = new SellItemModel();
	private List<String> specs = new ArrayList<String>();
	private String category_Name;
	private String subCategory_Name;
	SellItemService sellItemService = new SellItemService(itemModel);
	
	public String execute()
	{
		category_Name = itemModel.getCategory_Name();
		subCategory_Name = itemModel.getSubCategory_Name();
		specs = sellItemService.addItemDetails(itemModel.getCategory_Name(), itemModel.getSubCategory_Name());
		System.out.println(specs);
		return SUCCESS;
	}
	@Override
	public SellItemModel getModel() {
		// TODO Auto-generated method stub
		return itemModel;
	}
	public List<String> getSpecs() {
		return specs;
	}
	public void setSpecs(List<String> specs) {
		this.specs = specs;
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
	
}
