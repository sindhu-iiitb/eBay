package ebay.iiitb.viewoffers;

public class ViewOffersModel {
	
	
	 
	private int i_surkey;
	private String item_Name;
	private String item_desc;
	private String picture;
	private int seller_id;
	private int price;
	private int discount;
	private int priceafterdiscount;
	private int shippingcost;
	
	private int quantity;

	private String num_of_items_sold;
	private String warranty;
	private String advt_status;
	private String color;
	
	private String condition;
	private int weight;
	private String brand;
	
	private String expiry_date;
	private String duration;
	private String paymentmode;
	
	private String shipping_details;
	private String handlingtime;
	private String freeshipping;
	
	private int category_id;
	private int subcategory_id;
	private String type;
	
	private String serviced_in_india;
	private String model;
	private String size;
	private String material;
	
	private String sellerfeedback;
	private String rating;
	private String sellername;
	private String phoneno;
	private String categoryname;
	private String subcategoryname;
	
	private String address;//exam
	
	private String deal_eligible;
	private String dealitems;
	private String deal_added;
	private int totalcost;
	private int vat;
	private int notavailable;
	
	
	
	public String getDeal_added() {
		return deal_added;
	}
	public void setDeal_added(String deal_added) {
		this.deal_added = deal_added;
	}
	public int getNotavailable() {
		return notavailable;
	}
	public void setNotavailable(int notavailable) {
		this.notavailable = notavailable;
	}
	public int getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(int totalcost) {
		this.totalcost = totalcost;
	}
	public String getDealitems() {
		return dealitems;
	}
	public void setDealitems(String dealitems) {
		this.dealitems = dealitems;
	}
	public String getDeal_eligible() {
		return deal_eligible;
	}
	public void setDeal_eligible(String deal_eligible) {
		this.deal_eligible = deal_eligible;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getSellerfeedback() {
		return sellerfeedback;
	}
	public void setSellerfeedback(String sellerfeedbak) {
		this.sellerfeedback = sellerfeedbak;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getSellername() {
		return sellername;
	}
	public void setSellername(String sellername) {
		this.sellername = sellername;
	}
	public int getI_surkey() {
		return i_surkey;
	}
	public void setI_surkey(int i_surkey) {
		this.i_surkey = i_surkey;
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
	
	public int getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	
	public String getNum_of_items_sold() {
		return num_of_items_sold;
	}
	public void setNum_of_items_sold(String num_of_items_sold) {
		this.num_of_items_sold = num_of_items_sold;
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
	public int getWeight() {
		return weight;
	}
	public void setWeight(int i) {
		this.weight = i;
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
	public String getPaymentmode() {
		return paymentmode;
	}
	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}
	public String getShipping_details() {
		return shipping_details;
	}
	public void setShipping_details(String shipping_details) {
		this.shipping_details = shipping_details;
	}
	public String getHandlingtime() {
		return handlingtime;
	}
	public void setHandlingtime(String handlingtime) {
		this.handlingtime = handlingtime;
	}
	public String getFreeshipping() {
		return freeshipping;
	}
	public void setFreeshipping(String freeshipping) {
		this.freeshipping = freeshipping;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getSubcategory_id() {
		return subcategory_id;
	}
	public void setSubcategory_id(int subcategory_id) {
		this.subcategory_id = subcategory_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getServiced_in_india() {
		return serviced_in_india;
	}
	public void setServiced_in_india(String serviced_in_india) {
		this.serviced_in_india = serviced_in_india;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	
	
	//private String item_surrogate_key;
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}


	public int getPriceafterdiscount() {
		return priceafterdiscount;
	}
	public void setPriceafterdiscount(int priceafterdiscount) {
		this.priceafterdiscount = priceafterdiscount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getShippingcost() {
		return shippingcost;
	}
	public void setShippingcost(int shippingcost) {
		this.shippingcost = shippingcost;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getSubcategoryname() {
		return subcategoryname;
	}
	public void setSubcategoryname(String subcategoryname) {
		this.subcategoryname = subcategoryname;
	}
	public int getVat() {
		return vat;
	}
	public void setVat(int vat) {
		this.vat = vat;
	}
	
	
	
}
