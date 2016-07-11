package ebay.iiitb.deals;

public class DealsModel {
	
private String dealtitle;
private int deals_id;
private String flag;
private int itemid;
private String itemname;
private int price;
private int itemsavailable;
private int sellerid;
private String picture;
private int quantity;
private int i_surkey;
private String sellername;
private double sellerrating;
private int numberofbuyers;

//private int i_surkey2;
//private int i_surkey3;



public int getI_surkey() {
	return i_surkey;
}
public double getSellerrating() {
	return sellerrating;
}
public void setSellerrating(double sellerrating) {
	this.sellerrating = sellerrating;
}
public String getSellername() {
	return sellername;
}
public void setSellername(String sellername) {
	this.sellername = sellername;
}

public int getNumberofbuyers() {
	return numberofbuyers;
}
public void setNumberofbuyers(int numberofbuyers) {
	this.numberofbuyers = numberofbuyers;
}
public void setI_surkey1(int i_surkey) {
	this.i_surkey = i_surkey;
}
//public int getI_surkey2() {
//	return i_surkey2;
//}
//public void setI_surkey2(int i_surkey2) {
//	this.i_surkey2 = i_surkey2;
//}
//public int getI_surkey3() {
//	return i_surkey3;
//}
//public void setI_surkey3(int i_surkey3) {
//	this.i_surkey3 = i_surkey3;
//}
public String getFlag() {
	return flag;
}
public void setFlag(String flag) {
	this.flag = flag;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getItemsavailable() {
	return itemsavailable;
}
public void setItemsavailable(int itemsavailable) {
	this.itemsavailable = itemsavailable;
}
public int getSellerid() {
	return sellerid;
}
public void setSellerid(int sellerid) {
	this.sellerid = sellerid;
}
public String getPicture() {
	return picture;
}
public void setPicture(String picture) {
	this.picture = picture;
}

public String getDealtitle() {
	return dealtitle;
}
public void setDealtitle(String dealtitle) {
	this.dealtitle = dealtitle;
}
public int getItemid() {
	return itemid;
}
public void setItemid(int id1) {
	this.itemid = id1;
}
public String getItemname() {
	return itemname;
}
public void setItemname(String itemname) {
	this.itemname = itemname;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getDeals_id() {
	return deals_id;
}
public void setDeals_id(int deals_id) {
	this.deals_id = deals_id;
}

}
