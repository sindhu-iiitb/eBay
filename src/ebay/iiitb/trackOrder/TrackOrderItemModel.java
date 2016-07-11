package ebay.iiitb.trackOrder;

public class TrackOrderItemModel {
	private int i_surkey;
	private String item_name;
	private String picture;
	private String price;
	private int quantity;
	private int o_surkey;
	
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
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
	
	public int getI_surkey() {
		return i_surkey;
	}
	public void setI_surkey(int i_surkey) {
		this.i_surkey = i_surkey;
	}
	public int getO_surkey() {
		return o_surkey;
	}
	public void setO_surkey(int o_surkey) {
		this.o_surkey = o_surkey;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
