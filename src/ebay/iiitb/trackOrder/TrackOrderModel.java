package ebay.iiitb.trackOrder;

public class TrackOrderModel {
	private int order_id;
	private int totalcost;
	private String transaction_date;
	private String ship_before;
	private String order_status;
	
	
	public int getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(int totalcost) {
		this.totalcost = totalcost;
	}
	public String getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}
	public String getShip_before() {
		return ship_before;
	}
	public void setShip_before(String ship_before) {
		this.ship_before = ship_before;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	
	

}
