import java.math.BigDecimal;

public class Items
{
	private String itemCode;
	private String picture;
	private String name;
	private int quantity;
	private String description;
	private BigDecimal price;
	private String healthbenefits;
	private String type;

	public void setItemCode(String ic) {
		itemCode = ic;
	}

	public String getItemCode() {
		return(itemCode);
	}

	public void setPicture(String pic) {
		picture = pic;
	}
	
	public String getPicture() {
		return(picture);
	}

	public void setName(String n) {
		name = n;
	}
	
	public String getName() {
		return(name);
	}

	public void setQuantity(int q) {
		quantity = q;
	}

	public int getQuantity() {
		return(quantity);
	}

	public void setDescription(String d) {
		description = d;
	}

	public String getDescription() {
		return(description);
	}

	public void setHealthBenefits(String h) {
		healthbenefits = h;
	}

	public String getHealthBenefits() {
		return(healthbenefits);
	}

	public void setPrice(BigDecimal p) {
		price = p;
	}

	public BigDecimal getPrice() {
		return(price);
	}

	public void setType(String typ) {
		type = typ;
	}

	public String getType() {
		return(type);
	}

	public String toString() {
		String str = "\n Item Code:" + itemCode + "\nPicture: " + picture + " \nName: " + name + "\nDescription " + description +"\nDescription: " + "\nPrice: " + price + "\nHealth Benefits: " + healthbenefits ;
		return(str);
	}
}
