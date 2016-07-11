package ebay.iiitb.deals;

public class InsertDealModel {
private String deal_title;
private String item1;
private String item2;
private String item3;
private int totalCost;
private int sellerid;

public int getTotalCost() {
	return totalCost;
}
public void setTotalCost(int totalCost) {
	this.totalCost = totalCost;
}
public int getSellerid() {
	return sellerid;
}
public void setSellerid(int sellerid) {
	this.sellerid = sellerid;
}

public String getDeal_title() {
	return deal_title;
}
public void setDeal_title(String deal_title) {
	this.deal_title = deal_title;
}
public String getItem1() {
	return item1;
}
public void setItem1(String item1) {
	this.item1 = item1;
}
public String getItem2() {
	return item2;
}
public void setItem2(String item2) {
	this.item2 = item2;
}
public String getItem3() {
	return item3;
}
public void setItem3(String item3) {
	this.item3 = item3;
}

}
