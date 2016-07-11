package ebay.iiitb.Sell;

public class SellItemModel {
	private String i_surkey;
	private String itemid;
	private String item_Name;
	private String item_desc; 
	private String picture;
	private String seller_Id;
	private String price;
	private String category_Name;
	private String subCategory_Name;
	private int categoryId;
	private int subCategoryId;
	private int discount;
	private int quantity;
	private String sold;
	private String warranty;
	private String advt_status;
	private String color;
	private String condition;
	private String weight;
	private String brand;
	private String expiry_date;
	private String duration;
	private String paymentmode;
	private String shippingdetails;	
	private String handlingtime;
	private int shippingcost;
	private String type;
	private String serviced_in_india;
	private String model;
	private String size;
	private String material;
	private String from_date;
	private String to_date;
	private int adt_surkey;
	private String deal_eligible;
	private String deal_added;
	private String deal_title;
	public int advt_cost;
	public String att0, att1, att2, att3, att4, att5, att6, att7, att8, att9;
	
	
	
	public int getAdvt_cost() {
		return advt_cost;
	}
	public void setAdvt_cost(int advt_cost) {
		this.advt_cost = advt_cost;
	}
	public String getItem_Name() {
		return item_Name;
	}
	public void setItem_Name(String item_Name) {
		this.item_Name = item_Name;
	}
	public String getItem_desc() {
		return item_desc;
	}
	public void setItem_desc(String item_desc) {
		this.item_desc = item_desc;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getSeller_Id() {
		return seller_Id;
	}
	public void setSeller_Id(String seller_Id) {
		this.seller_Id = seller_Id;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getSubCategory_Name() {
		return subCategory_Name;
	}
	public void setSubCategory_Name(String subCategory_Name) {
		this.subCategory_Name = subCategory_Name;
	}
	public String getCategory_Name() {
		return category_Name;
	}
	public void setCategory_Name(String category_Name) {
		this.category_Name = category_Name;
	}
	public void setCategoryId(int catid) {
		this.categoryId = catid;
		
	}
	public void setSubCategoryId(int subcatid) {
		this.subCategoryId = subcatid;
		
	}
	public int getCategoryId() {
		return this.categoryId;
		
	}
	public int getSubCategoryId() {
		return this.subCategoryId;
		
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getSold() {
		return sold;
	}
	public void setSold(String sold) {
		this.sold = sold;
	}
	public String getWarranty() {
		return warranty;
	}
	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}
	public String getAdvt_status() {
		return advt_status;
	}
	public void setAdvt_status(String advt_status) {
		this.advt_status = advt_status;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getShippingdetails() {
		return shippingdetails;
	}
	public void setShippingdetails(String shippingdetails) {
		this.shippingdetails = shippingdetails;
	}
	public String getPaymentmode() {
		return paymentmode;
	}
	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}
	public String getI_surkey() {
		return i_surkey;
	}
	public void setI_surkey(String i_surkey) {
		this.i_surkey = i_surkey;
	}
	public String getHandlingtime() {
		return handlingtime;
	}
	public void setHandlingtime(String handlingtime) {
		this.handlingtime = handlingtime;
	}
	public String getServiced_in_india() {
		return serviced_in_india;
	}
	public void setServiced_in_india(String serviced_in_india) {
		this.serviced_in_india = serviced_in_india;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getFrom_date() {
		return from_date;
	}
	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}
	public String getTo_date() {
		return to_date;
	}
	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}
	public int getAdt_surkey() {
		return adt_surkey;
	}
	public void setAdt_surkey(int adt_surkey) {
		this.adt_surkey = adt_surkey;
	}
	public int getShippingcost() {
		return shippingcost;
	}
	public void setShippingcost(int shipppingcost) {
		this.shippingcost = shipppingcost;
	}
	public String getDeal_eligible() {
		return deal_eligible;
	}
	public void setDeal_eligible(String deal_eligible) {
		this.deal_eligible = deal_eligible;
	}
	public String getDeal_added() {
		return deal_added;
	}
	public void setDeal_added(String deal_added) {
		this.deal_added = deal_added;
	}
	public String getDeal_title() {
		return deal_title;
	}
	public void setDeal_title(String deal_title) {
		this.deal_title = deal_title;
	}
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	
}
