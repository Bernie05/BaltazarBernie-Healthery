 import java.math.BigDecimal;

public class Beverage extends Items
{
	private final String PRODUCTID;

	public Beverage(String id, String ic, String pic, String n, int q, String d, BigDecimal p, String h, int ocd, int did, String typ) {
		PRODUCTID = id;
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
		return(PRODUCTID);
	}

	@Override
	public String toString() {
		String str = "\nProduct ID: " + PRODUCTID + super.toString();
		return(str);
	}
}
