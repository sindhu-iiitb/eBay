package ebay.iiitb.cart;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class CartAction extends ActionSupport {
	
	private static final long serialVersionUID = 7768198189570528281L;
	Map<String, Object> session = ActionContext.getContext().getSession();
	private CartModel cartModel = new CartModel();
	private CartItemModel itemModel = new CartItemModel();
	CartService cartService = new CartService();
	private ArrayList<CartModel> itemsInCart = new ArrayList<CartModel>();
	private ArrayList<CartItemModel> dealsItems = new ArrayList<CartItemModel>();
	private int item_key = 0;
	private int quantity;
	private String quantityCheck;
	private int orderTotal = 0;
	private int vatAmount = 0;
	private int deals_id = 0;
	
	
	public int getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(int orderTotal) {
		this.orderTotal = orderTotal;
	}

	public int getItem_key() {
		return item_key;
	}

	public void setItem_key(int item_key) {
		this.item_key = item_key;
	}

	public ArrayList<CartModel> getItemsInCart() {
		return itemsInCart;
	}

	public void setItemsInCart(ArrayList<CartModel> itemsInCart) {
		this.itemsInCart = itemsInCart;
	}

	int cartId = 0;
	
	public String execute()
	{
		//Get the user id from the session object;
		int u_surkey = (Integer) session.get("user_surr_key");
		System.out.println("In cart Action I got surr key" + u_surkey);
		System.out.println("In Action cart id" + cartService.getCartId(u_surkey, getItem_key()));
		cartId = cartService.getCartId(u_surkey, getItem_key());
		if(cartId == 0 && getItem_key()!= 0)
		{
			cartService.insertIntoCart(u_surkey, getItem_key(),1,0,"No",0);
		}
		else 
		{
				if(getItem_key()!=0)
				{
					int qty = cartService.getCartQty(u_surkey, getItem_key());
					if(cartService.Updateqty(cartId, qty+1, getItem_key()))
					{
						
					}
					else
					{
						return ERROR;
					}
				}
		}
		if(getDeals_id()!= 0)
		{
			setDealsItems(cartService.getItemsOfDeals(getDeals_id()));
			String status = "No";
			int price = 0;
			for(CartItemModel cartItemModel: dealsItems )
			{	
				if(cartItemModel.getFreeflag() == 4)
				{
					status = "Yes";
					price= cartItemModel.getPrice();
					
				}
				cartId = cartService.getCartId(u_surkey,cartItemModel.getI_surkey());
				if(cartId == 0)
				{	
					cartService.insertIntoCart(u_surkey, cartItemModel.getI_surkey(), 1,deals_id,status,price);
					status = "No";
					price = 0;
				}
				else
				{
					int qty = cartService.getCartQty(u_surkey, cartItemModel.getI_surkey());
					if(!cartService.Updateqty(cartId, qty+1,cartItemModel.getI_surkey()))
						return ERROR;
				}
			}
		}
		
		itemsInCart = cartService.itemsInYourCart(u_surkey);
//		for(CartModel cartModel: itemsInCart )
//		{
//			System.out.println(cartModel.getFreeitem());
//			if(cartModel.getFreeitem().equals("Yes"))
//			{
//				System.out.println("im hereeee");
//				cartModel.getItem().setPrice(0);
//			}
//		}
		calculateDiscount();
		return SUCCESS;
	}
	
	public String removeCartItem()
	{
		int deal_key =0;
		int dealItemsCount = 0;
		int freeItemIndex = 0;
		CartModel cm = new CartModel();
		CartService cartService = new CartService();
		int u_surkey = (Integer) session.get("user_surr_key");
		cartId = cartService.getCartId(u_surkey, getItem_key());
		cartService.removeFromCart(cartId);
		setItemsInCart(cartService.itemsInYourCart(u_surkey));//Update cart after removing the item

//		for(CartModel cartModel: itemsInCart)
//		{
//			if(cartModel.getItem().getI_surkey() == getItem_key())
//			{
//				deal_key = cartModel.getDeals_id();
//			}
//		}
//		if(deal_key != 0){
//			for(CartModel cartModel: itemsInCart)
//			{
//				if(cartModel.getDeals_id() == deal_key && cartModel.getFreeitem().equals("No"))
//					dealItemsCount++;
//				if(cartModel.getFreeitem().equals("Yes") && cartModel.getDeals_id() == deal_key)
//				{
//					cm = cartModel;
//				}
//			}
//			if(dealItemsCount != 2)
//			{
//					freeItemIndex = itemsInCart.indexOf(cm);			
//			}
//			if(freeItemIndex !=0)
//			itemsInCart.get(freeItemIndex).setFreeitemprice(cm.getFreeitemprice());
//		}
		calculateDiscount();
		ActionContext.getContext().getSession().put("itemsInCart", itemsInCart);
		return SUCCESS;
	}
	
	public String updateQuantity_in_cart()
	{
		
		CartService cartService = new CartService();
		
		int u_surkey = (Integer) session.get("user_surr_key");
		cartId = cartService.getCartId(u_surkey, getItem_key());
		if(cartService.Updateqty(cartId, getQuantity(),getItem_key()))
		{
			setItemsInCart(cartService.itemsInYourCart(u_surkey));//Update cart after updating the item
			
			calculateDiscount();
			ActionContext.getContext().getSession().put("itemsInCart", itemsInCart);
			
			setQuantityCheck("1");
			
		}
		else
		{
			setQuantityCheck("0");
		}
			return SUCCESS;
		
	}
	public void calculateDiscount()
	{
		int disc, o_total = 0;
		for(CartModel cartModel: itemsInCart )
		{
			disc = (cartModel.getItem().getPrice()*cartModel.getItem().getDiscount())/100;
			cartModel.getItem().setPriceafterdiscount(cartModel.getItem().getPrice() - disc);
			o_total = o_total + (cartModel.getItem().getPrice() * Integer.parseInt(cartModel.getItem().getQuantity()));
			o_total = o_total + cartModel.getItem().getShippingcost();
			}
		int vat_percent = cartService.getVatPercentage();
		int amount = (o_total*vat_percent)/100;
		setVatAmount(amount);
		setOrderTotal(o_total + amount);	
		
	}
	public CartModel getCartModel() {
		return cartModel;
	}
	public void setCartModel(CartModel cartModel) {
		this.cartModel = cartModel;
	}

	public CartItemModel getItemModel() {
		return itemModel;
	}

	public void setItemModel(CartItemModel itemModel) {
		this.itemModel = itemModel;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getVatAmount() {
		return vatAmount;
	}

	public void setVatAmount(int vatAmount) {
		this.vatAmount = vatAmount;
	}

	public int getDeals_id() {
		return deals_id;
	}

	public void setDeals_id(int deals_id) {
		this.deals_id = deals_id;
	}

	public ArrayList<CartItemModel> getDealsItems() {
		return dealsItems;
	}

	public void setDealsItems(ArrayList<CartItemModel> dealsItems) {
		this.dealsItems = dealsItems;
	}

	public String getQuantityCheck() {
		return quantityCheck;
	}

	public void setQuantityCheck(String quantityCheck) {
		this.quantityCheck = quantityCheck;
	}

	

	
	
	
}
