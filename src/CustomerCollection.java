import java.util.ArrayList;

public class CustomerCollection
{
	private ArrayList<Customer> customers;
	private static CustomerCollection _instance = null;

	public static CustomerCollection instance() {
		if(_instance == null) {
			_instance = new CustomerCollection();
		}
		return(_instance);
	}

	public CustomerCollection() {
		customers = new ArrayList<Customer>();
	}

	public void addCustomer(Customer acc) {
		customers.add(acc);
	}

	public void removeCustomer(Customer acc) {
		customers.remove(acc);
	}

	public ArrayList<Customer> getAllCustomers() {
		return(customers);
	}

	public Customer getIndexById(int acc) {
		return(customers.get(acc));
	}

	public int getCustomerCount() {
		return(customers.size());
	}

	public ArrayList<Customer> customerSearch(String account) {
		ArrayList<Customer> cus = new ArrayList<Customer>();
		String customerSearch = account.toLowerCase();
		for(Customer a: getAllCustomers()) {
			if(search(a, customerSearch)) {
				cus.add(a);
			}
		}
		return(cus);
	}

	public boolean search(Customer a, String aname) {
		String account = a.getFullName().toLowerCase();
		if(account.contains(aname)) {
			return(true);
		}
		return(false);
	}
}
