package ebay.iiitb.Sell;

public class CategoryModel {
	
	private String category_Id;
	private String category_Name;
	private String category_Parent;
	private String category_Group;
	private String item_Id;
	private String item_Name;
	private String price;
	private String picture;
	
	public String getItem_Id() {
		return item_Id;
	}
	public void setItem_Id(String item_Id) {
		this.item_Id = item_Id;
	}
	public String getItem_Name() {
		return item_Name;
	}
	public void setItem_Name(String item_Name) {
		this.item_Name = item_Name;
	}

	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public char[] getcategory_Name() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getCategory_Id() {
		return category_Id;
	}
	public void setCategory_Id(String category_Id) {
		this.category_Id = category_Id;
	}
	public String getCategory_Name() {
		return category_Name;
	}
	public void setCategory_Name(String category_Name) {
		this.category_Name = category_Name;
	}
	public String getCategory_Parent() {
		return category_Parent;
	}
	public void setCategory_Parent(String category_Parent) {
		this.category_Parent = category_Parent;
	}
	public String getCategory_Group() {
		return category_Group;
	}
	public void setCategory_Group(String category_Group) {
		this.category_Group = category_Group;
	}

}
