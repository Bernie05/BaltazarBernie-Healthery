import java.math.BigDecimal;

public class Food extends Items
{
	private final String FOODID;

	public Food(String id, String ic, String pic, String n, int q, String d, BigDecimal p, String h, String typ) {
		FOODID = id;
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
		return(FOODID);
	}

	@Override
	public String toString() {
		String str = "\nFood ID: " + FOODID + super.toString();
		return(str);
	}
}
