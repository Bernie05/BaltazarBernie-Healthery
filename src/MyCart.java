import java.util.ArrayList;
import java.math.BigDecimal;

public class MyCart
{
	private final String CARTID;
	private String itemCode;
	private String customerCart;
	private String itemName;
	private BigDecimal price;
	private BigDecimal quantity;

	public MyCart(String id, String ic,String cc, String i, BigDecimal p, BigDecimal q) {
		CARTID = id;
		customerCart = cc;
		itemCode = ic;
		itemName = i;
		price = p;
		quantity = q;
	}

	public String getCARTID() {
		return(CARTID);
	}

	public void setCustomerCart(String crt) {
		customerCart = crt;
	}

	public String getCustomerCart() {
		return(customerCart);
	}
	public void setItemCode(String c) {
		itemCode = c;
	}

	public String getItemCode() {
		return(itemCode);
	}

	public void setItemName(String in) {
		itemName = in;
	}

	public String getItemName() {
		return(itemName);
	}

	public void setPrice(BigDecimal p) {
		price = p;
	}

	public BigDecimal getPrice() {
		return(price);
	}

	public void setQuantity(BigDecimal q) {
		quantity = q;
	}

	public BigDecimal getQuantity() {
		return(quantity);
	}
}
