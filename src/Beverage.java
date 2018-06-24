 import java.math.BigDecimal;

public class Beverage extends Items
{
	private final String BEVERAGEID;

	public Beverage(String id, String ic, String pic, String n, int q, String d, BigDecimal p, String h, String typ) {
		BEVERAGEID = id;
		setItemCode(ic);
		setPicture(pic);
		setName(n);
		setQuantity(q);
		setDescription(d);
		setPrice(p);
		setHealthBenefits(h);
		setType(typ);
	}

	public String getItemID() {
		return(BEVERAGEID);
	}

	@Override
	public String toString() {
		String str = "\nProduct ID: " + BEVERAGEID + super.toString();
		return(str);
	}
}
