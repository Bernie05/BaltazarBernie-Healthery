public class DeliverOrder extends Person
{
	private final String DELIVERORDERID;
	private String company;

	public DeliverOrder(String id, String c, String n, String ad, String bday, String g, String cn) {
		DELIVERORDERID = id;
		company = c;
		setFullName(n);
		setAddress(ad);
		setBirthday(bday);
		setGender(g);
		setContactNo(cn);
	}

	public String getID() {
		return(DELIVERORDERID);
	}

	public void setCompany(String com) {
		company = com;
	}

	public String getCompany() {
		return(company);
	}

	@Override
	public String toString() {
		String str = "\nDeliver Order ID: " + DELIVERORDERID + "\nCompany: " + company + toString();
		return(str);
	}
}
