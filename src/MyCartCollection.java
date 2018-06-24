import java.util.ArrayList;
import java.math.BigDecimal;
import java.lang.StringBuilder;

public class MyCartCollection
{
	private ArrayList<MyCart> mycart;
	private static MyCartCollection _instance = null;
	private final BigDecimal VAT = new BigDecimal("0.12");

	public static MyCartCollection instance() {
		if(_instance == null) {
			_instance = new MyCartCollection();
		}
		return(_instance);
	}

	public MyCartCollection() {
		mycart = new ArrayList<MyCart>();
	}

	public void addToCart(MyCart acc) {
		mycart.add(acc);
	}

	public void removeCart(MyCart acc) {
		mycart.remove(acc);
	}

	public ArrayList<MyCart> getAllCart() {
		return(mycart);
	}

	public MyCart getIndexById(int acc) {
		return(mycart.get(acc));
	}

	public int getMyCartCount() {
		return(mycart.size());
	}

	public String getTotalValue(String ID) {
		StringBuilder sb = new StringBuilder("");
		BigDecimal totalPurchase = new BigDecimal("0");
		BigDecimal quantity = new BigDecimal("0");
		BigDecimal itemPrice = new BigDecimal("0");
		BigDecimal totalPayment = null;
		BigDecimal totalWithVat = null;
		for(MyCart a: getAllCart()) {
			if(searchID(a, ID)) {
				itemPrice = a.getPrice().multiply(a.getQuantity());
				totalPurchase = totalPurchase.add(itemPrice);
				totalWithVat = VAT.multiply(totalPurchase).setScale(2, BigDecimal.ROUND_HALF_UP);
				totalPayment = totalPurchase.add(totalWithVat);
				sb.append("\nItem Name: " + a.getItemName() );
				sb.append("\nItem Price: " + a.getPrice());
				sb.append("\nQuantity: " + a.getQuantity());
				sb.append("\nVAT: " + VAT  + "%\n");
			}
		}
		sb.append("\nTotal Payment: " + totalPayment);
		return(sb.toString());
	}

	public ArrayList<MyCart> cartSearch(String myCart) {
		ArrayList<MyCart> cart = new ArrayList<MyCart>();
		String myCartSearch = myCart.toLowerCase();
		for(MyCart a: getAllCart()) {
			if(search(a, myCartSearch)) {
				cart.add(a);
			}
		}
		return(cart);
	}

	public boolean searchID(MyCart a, String cart) {
		String myID = a.getCustomerCart();
		if(myID.contains(cart)) {
			return(true);
		}
		return(false);
	}

	public boolean search(MyCart a, String cart) {
		String cartItem = a.getItemName().toLowerCase();
		if(cartItem.contains(cart)) {
			return(true);
		}
		return(false);
	}
}
