public class Customer extends Person
{ 
	private final String CLIENTID;
	
	public Customer(String id, String n, String ad, String bday, String g, String cn) {
		CLIENTID = id;
		setFullName(n);
		setAddress(ad);
		setBirthday(bday);
		setGender(g);
		setContactNo(cn);
	}
	public String getID() {
		return(CLIENTID);
	}

	@Override
	public String toString() {
		String str = "\nClient ID: " + CLIENTID + super.toString();
		return(str);
	}
}
