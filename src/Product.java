import java.math.BigDecimal;

public class Product extends Items
{
	private final String ORDERID;

	public Product(String id, String ic, String pic, String n, int q, String d, BigDecimal p, String h, int ocd, int did, String typ) {
		ORDERID = id;
		setItemCode(ic);
		setPicture(pic);
		setName(n);
		setQuantity(q);
		setDescription(d);
		setPrice(p);
		setHealthBenefits(h);
		setOrderCustomerID(ocd);
		setDeliverID(did);
		setType(typ);
	}

	public String getItemID() {
		return(ORDERID);
	}

	public String toString() {
		String str = "\nProduct ID: " + ORDERID + super.toString();
		return(str);
	}
}
