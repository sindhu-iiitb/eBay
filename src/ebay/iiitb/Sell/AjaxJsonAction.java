//tables : advt_detail_table
//advt_detail_table : cost , adt_surkey
package ebay.iiitb.Sell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;

import ebay.iiitb.DBUtil.DbConnection;

public class AjaxJsonAction implements Action{

private Map<String, String> categoryMap = new LinkedHashMap<String, String>();
private ArrayList<String> sub;
private String dummyMsg;
private String categoryName;
private SellItemModel itemModel = new SellItemModel();
private int cost;
private String start;
private String end;
private String adkey;
SellItemService sellItemService = new SellItemService(itemModel);
DisplaySubDropDownService displaySubCategoriesService = new DisplaySubDropDownService();
GetSubcategoryIDService getSubcategoryIDService=new GetSubcategoryIDService();
public String execute() {
	
	sub = displaySubCategoriesService.displaySubDropDown(categoryName);
//	Integer i=0,j;
	String index;
	for (String a:sub) {
		index =Integer.toString(getSubcategoryIDService.getSubcategoryId(a));
		System.out.println(index);
		categoryMap.put(index,a);
	}
     return "success";
}

public String calcost() throws Exception {
	
	DbConnection db = new DbConnection();
	Connection con = db.getConnection();
	SimpleDateFormat from2 = new SimpleDateFormat("yyyy-MM-dd");
	
	Date fromdate = from2.parse(getStart().substring(0,10));      
	Date todate = from2.parse(getEnd().substring(0,10));  
	long diff = Math.abs(fromdate.getTime() - todate.getTime());
	int diffDays = (int)(diff / (24 * 60 * 60 * 1000));
	String getperdaycost = "select cost from advt_detail_table where adt_surkey ="+getAdkey();
	System.out.println("***************************************"+getperdaycost);
	PreparedStatement pscost=con.prepareStatement(getperdaycost);
	ResultSet rscost=pscost.executeQuery();
	while (rscost.next()) {
		setCost( rscost.getInt(1)*diffDays);
		break;
	}
	System.out.println("cost is::::::::::::::::::"+diff);
     return "success";
}

public String getDummyMsg() {
	return dummyMsg;
}
public void setDummyMsg(String dummyMsg) {
	this.dummyMsg = dummyMsg;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
public ArrayList<String> getSub() {
	return sub;
}
public void setSub(ArrayList<String> sub) {
	this.sub = sub;
}
public Map<String, String> getCategoryMap() {
	return categoryMap;
}
public void setCategoryMap(Map<String, String> categoryMap) {
	this.categoryMap = categoryMap;
}

public int getCost() {
	return cost;
}

public void setCost(int cost) {
	this.cost = cost;
}

public String getStart() {
	return start;
}

public void setStart(String start) {
	this.start = start;
}

public String getEnd() {
	return end;
}

public void setEnd(String end) {
	this.end = end;
}

public String getAdkey() {
	return adkey;
}

public void setAdkey(String adkey) {
	this.adkey = adkey;
}

}
