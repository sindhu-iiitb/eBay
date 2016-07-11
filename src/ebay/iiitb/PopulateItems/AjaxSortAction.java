//tables : item
//item : i_surkey , sc_surkey , quantity , brand , price
package ebay.iiitb.PopulateItems;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import ebay.iiitb.DBUtil.DbConnection;


import com.opensymphony.xwork2.ActionSupport;


public class AjaxSortAction extends ActionSupport{

	//parameter received from subcategoryclickjsp
	private String sortid;
	private String subcatid;
	//private String pricefilter;
	private String toprice;
	private String fromprice;
	private String brand;
	
	

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getToprice() {
		return toprice;
	}

	public void setToprice(String toprice) {
		this.toprice = toprice;
	}

	public String getFromprice() {
		return fromprice;
	}

	public void setFromprice(String fromprice) {
		this.fromprice = fromprice;
	}

	private Map<Integer, ItemModel> items = new LinkedHashMap<Integer, ItemModel>();
	ItemModel item;
	
	
	public Map<Integer, ItemModel> getItems() {
		return items;
	}

	public void setItems(Map<Integer, ItemModel> items) {
		this.items = items;
	}

	public ItemModel getItem() {
		return item;
	}

	public void setItem(ItemModel item) {
		this.item = item;
	}

	public Map<Integer, ItemModel> getSubcatmap() {
		return items;
	}

	public void setSubcatmap(Map<Integer, ItemModel> subcatmap) {
		this.items = subcatmap;
	}
	
	public String getSubcatid() {
		return subcatid;
	}

	public void setSubcatid(String subcatid) {
		this.subcatid = subcatid;
	}

	public String getSortid() {
		return sortid;
	}

	public void setSortid(String sortid) {
		this.sortid = sortid;
	}
	
//	public String getPricefilter() {
//		return pricefilter;
//	}
//
//	public void setPricefilter(String pricefilter) {
//		this.pricefilter = pricefilter;
//	}

	public String execute(){
		System.out.println("in ajax sort action");
		int cat2_id = Integer.parseInt(subcatid);
		int srtid = Integer.parseInt(sortid);
		int fromcost = Integer.parseInt(fromprice);
		int tocost = Integer.parseInt(toprice);
		System.out.println("Sort id is" + sortid);
		System.out.println("Sub category id is" + subcatid);
		System.out.println("From Cost:" + fromcost);
		System.out.println("To Cost" + tocost);
		System.out.println("Brand"+ brand);
		
		
		try{
			DbConnection db=new DbConnection();
			Connection con=db.getConnection();
			
			PreparedStatement ps;
			ResultSet rs;
						
			
			String sortquery = null;
			String filterquery1 = null;
			
			
			//filters
			
			//Price filter
			if(tocost==0 && fromcost==0 && brand.equals("-1")){
				filterquery1 = "SELECT i_surkey FROM item WHERE sc_surkey=? and quantity > ?";
				System.out.println("price & brand filter is null");
				
			}else if(tocost==0 && fromcost==0 && !brand.equals("-1")){
				filterquery1 = "SELECT i_surkey FROM item WHERE sc_surkey= ? AND   quantity > ? AND brand like '"+brand+"'" ;
				System.out.println("price filter is null");
				
			}
			else if((tocost!=0 || fromcost!=0) && brand.equals("-1"))
			{
				filterquery1 = "SELECT i_surkey FROM item WHERE sc_surkey= ? AND price BETWEEN + '"+ fromcost +"' AND '" + tocost +"' and quantity > ?" ;
				System.out.println("brand filter is null");
			}
			else if((tocost!=0 || fromcost!=0) && !brand.equals("-1"))
			{
				filterquery1 = "SELECT i_surkey FROM item WHERE sc_surkey= ? AND price BETWEEN + '"+ fromcost +"' AND '" + tocost +"' and quantity > ?  AND brand like '"+brand+"'" ;
				System.out.println("both filters are specified");
			}
			
			
			//selecting the query based on the 
			//sort by best match
			if(srtid == 1){
				sortquery="SELECT * FROM item WHERE i_surkey IN " + "(" + filterquery1 + ")";
			}
	
			//sort by price:ascending
			else if(srtid== 2){
				sortquery="SELECT * FROM item WHERE i_surkey IN" + "(" + filterquery1 + ")" + "ORDER BY price ASC";
			}
			
			//sort by price:descending
			else if(srtid == 3){
				sortquery="SELECT * FROM item WHERE i_surkey IN" + "(" + filterquery1 + ")" + "ORDER BY price DESC";
			}	
			
			ps =  con.prepareStatement(sortquery);
			ps.setInt(1, cat2_id);
			ps.setInt(2, 0);
			
			
			/*
			ps.setInt(1, cat2_id);
			
			
		*/	
			
			rs = ps.executeQuery();
			
			int i =1;
			while(rs.next()){
//				System.out.println(rs.getString("item_name"));
//				System.out.println(rs.getFloat("price"));
				ItemModel it = new ItemModel();
				it.setI_surkey(rs.getInt(1));
				it.setItem_Name(rs.getString(2));
				it.setPicture(rs.getString(3));
				it.setPrice(rs.getInt(4));
				it.setSubcategory_id(rs.getInt(24));
				it.setDiscount(rs.getString(7));
				it.setQuantity(rs.getString(8));
				System.out.println(it.getItem_Name());
				items.put(i, it);
				i++;	
			}
			
			System.out.println("Items fetched");
			
			String dummyMessage = "Ajax Action Triggered";
			return SUCCESS;

		}
		
		catch(Exception e){
			
			e.printStackTrace();
			return ERROR;
		}

	}
}
