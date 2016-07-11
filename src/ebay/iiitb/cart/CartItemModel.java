package ebay.iiitb.cart;

public class CartItemModel {

	private int i_surkey;
	private String itemName;
	private String picture;
	private  int price;
	private String item_desc;
	private String s_surkey;
	private String sellerName;
	private int discount;
	private int shippingcost;
	private String quantity;
	private int freeflag;
	private int priceafterdiscount;
	public int getI_surkey() {
		return i_surkey;
	}
	public void setI_surkey(int i_surkey) {
		this.i_surkey = i_surkey;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getItem_desc() {
		return item_desc;
	}
	public void setItem_desc(String item_desc) {
		this.item_desc = item_desc;
	}
	public String getS_surkey() {
		return s_surkey;
	}
	public void setS_surkey(String s_surkey) {
		this.s_surkey = s_surkey;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
//	public int getQuantity() {
//		return quantity;
//	}
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getShippingcost() {
		return shippingcost;
	}
	public void setShippingcost(int shippingcost) {
		this.shippingcost = shippingcost;
	}
	public int getFreeflag() {
		return freeflag;
	}
	public void setFreeflag(int freeflag) {
		this.freeflag = freeflag;
	}
	public int getPriceafterdiscount() {
		return priceafterdiscount;
	}
	public void setPriceafterdiscount(int priceafterdiscount) {
		this.priceafterdiscount = priceafterdiscount;
	}
	
	
	
	
	
	
}
