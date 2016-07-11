package ebay.iiitb.cart;

public class CartModel {
	
	private int cartId;
	private String freeitem;
	private int freeitemprice;
	private int deals_id;
	private CartItemModel item;
	private int quantity;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public CartItemModel getItem() {
		return item;
	}
	public void setItem(CartItemModel item) {
		this.item = item;
	}

	public String getFreeitem() {
		return freeitem;
	}
	public void setFreeitem(String freeitem) {
		this.freeitem = freeitem;
	}
	public int getFreeitemprice() {
		return freeitemprice;
	}
	public void setFreeitemprice(int freeitemprice) {
		this.freeitemprice = freeitemprice;
	}
	public int getDeals_id() {
		return deals_id;
	}
	public void setDeals_id(int deals_id) {
		this.deals_id = deals_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
