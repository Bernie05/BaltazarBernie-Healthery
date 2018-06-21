import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.*;

public class HealtheryDatabaseManager
{
	private static HealtheryDatabaseManager _instance = null;
	private CustomerCollection customers;
	private DeliverOrderCollection orders;
	private MyCartCollection myCart;
	private	ProductCollection products;
	private BeverageCollection beverages;
	
	public static HealtheryDatabaseManager instance() {
		if(_instance == null) {
			_instance = new HealtheryDatabaseManager();
		}
		return(_instance);
	}

	public HealtheryDatabaseManager() {
		customers = CustomerCollection.instance();
		orders = DeliverOrderCollection.instance();
		myCart = MyCartCollection.instance();
		products = ProductCollection.instance();
		beverages = BeverageCollection.instance();
		createDB();
	}

	public CustomerCollection getCustomerCollection() {
		return(customers);
	}

	public MyCartCollection getMyCarCollection() {
		return(myCart);
	}

	public ProductCollection getMyProductCollection() {
		return(products);
	}

	public BeverageCollection getMyBeverageCollection() {
		return(beverages);
	}

	public DeliverOrderCollection getMyDeliverOrderCollection() {
		return(orders);
	}

	public ArrayList<Object> search (String s) {
		ArrayList<Object> ao = new ArrayList<Object>();
		ArrayList<Customer> cr = customers.customerSearch(s);
		ArrayList<DeliverOrder> ee = orders.deliverOrderSearch(s);
		ArrayList<MyCart> mt =  myCart.cartSearch(s);
		ArrayList<Product> pt = products.productSearch(s);
		ArrayList<Beverage> be = beverages.beverageSearch(s);
		ao.addAll(cr);
		ao.addAll(ee);
		ao.addAll(mt);
		ao.addAll(pt);
		ao.addAll(be);
		return(ao);
	}

	public Connection createDB() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/healtherydb?user=healthery&" + 
			"password=healthery&serverTimezone=UTC&useSSL=false");
			System.out.println("you are now connected");
			readFromDB(conn);
		}
		catch(Exception e) {
			conn = null;
			e.printStackTrace();
		}
		return(conn);
	}

	public boolean readFromDB(Connection conn) throws Exception {
		ResultSet rs = null;
		Statement stmt = null;
		stmt = conn.createStatement();
		rs = stmt.executeQuery("Select * from tblCustomers;");
		while(rs.next()) {
			String[] str = {
				rs.getString("customerID"),
				rs.getString("fullname"),
				rs.getString("address"),
				rs.getString("birthday"),
				rs.getString("gender"),
				rs.getString("contact"),
				"customer"
			};
			createObject(str);
		}
		rs = stmt.executeQuery("Select * from tblProductOrder;");
		while(rs.next()) {
			String[] str = {
				rs.getString("productID"),
				rs.getString("code"),
				rs.getString("picture"),
				rs.getString("name"),
				rs.getString("quantity"),
				rs.getString("description"),
				rs.getString("price"),
				rs.getString("healthbenefits"),
				rs.getString("orderCustomerID"),
				rs.getString("deliveryID"),
				rs.getString("type")
			};
			createObject(str);
		}
		rs = stmt.executeQuery("Select * from tblDeliverer;");
		while(rs.next()) {
			String[] str = {
				rs.getString("delivererID"),
				rs.getString("companyname"),
				rs.getString("fullname"),
				rs.getString("address"),
				rs.getString("birthday"),
				rs.getString("gender"),
				rs.getString("contactNo"),
				"deliverer"
			};
			createObject(str);
		}
		rs = stmt.executeQuery("Select * from tblMyCart;");
		while(rs.next()) {
			String[] str = {
				rs.getString("cartID"),
				rs.getString("customerCart"),
				rs.getString("code"),
				rs.getString("name"),
				rs.getString("quantity"),
				rs.getString("price"),
				"cart"
			};
			createObject(str);
		}
		return(true);
	}

	public void createObject(String[] details) {
		int leng = details.length-1;
		String d = details[leng];
		if("customer".equals(d)) {
			Customer c = new Customer(details[0], details[1], details[2],
			details[3], details[4], details[5]);
			customers.addCustomer(c);
		}
		else if("food".equals(d)) {
			Product f = new Product(details[0], details[1], details[2],
			details[3], Integer.parseInt(details[4]), details[5], new BigDecimal(details[6]), details[7],
			Integer.parseInt(details[8]), Integer.parseInt(details[9]), details[10]);;
			products.addProduct(f);
		}
		else if("beverage".equals(d)) {
			Beverage b = new Beverage(details[0], details[1], details[2],
			details[3], Integer.parseInt(details[4]), details[5], new BigDecimal(details[6]), details[7],
			Integer.parseInt(details[8]), Integer.parseInt(details[9]), details[10]);
			beverages.addBeverage(b);
		}
		else if("cart".equals(d)) {
			MyCart dv = new MyCart(details[0], details[1], details[2], details[3], new BigDecimal(details[4]), new BigDecimal(details[5]));
			myCart.addToCart(dv);
		}
		else if("deliverer".equals(d)) {
			DeliverOrder dv = new DeliverOrder(details[0], details[1], details[2], details[3], details[4], details[5], details[6]);
			orders.addDeliverOrder(dv);
		}
	}
}
