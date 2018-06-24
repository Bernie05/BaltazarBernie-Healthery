import java.lang.StringBuilder;
import java.sql.*;

class HealtheryDatabase
{
	static Connection conn;
	private static HealtheryDatabase _instance = null;

	public static HealtheryDatabase instance() {
		if(_instance == null) {
			_instance = new HealtheryDatabase();
		}
		return(_instance);
	}

	private HealtheryDatabase() {
		createDB();
	}

	public static Connection createDB() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/healtherydb?user=healthery&" + 
			"password=healthery&serverTimezone=UTC&useSSL=false");
			System.out.println("you are now connected");
		}
		catch(Exception e) {
			conn = null;
			e.printStackTrace();
		}
		return(conn);
	}

	public String customerList(Connection conn) {
		StringBuilder sb = new StringBuilder("");
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM tblCustomers;");
			while(rs.next()) {
				sb.append("\nUsername: " + rs.getString("username"));
				sb.append("\nFullname: " + rs.getString("fullname"));
				sb.append("\nAddress: P" + rs.getString("address"));
				sb.append("\nBirthday: " + rs.getString("birthday"));
				sb.append("\nGender: " + rs.getString("gender"));
				sb.append("\nContact: " + rs.getString("contact"));
				sb.append("\nStatus: " + rs.getString("status") + "\n");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try{
				if(stmt!=null) {stmt.close();}
			}
			catch(Exception e) {}
			try{
				if(rs!=null) {rs.close();}
			}
			catch(Exception e) {}
		}
		return(sb.toString());
	}

	public String productList(Connection conn) {
		StringBuilder sb = new StringBuilder("");
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM tblItems;");
			while(rs.next()) {
				sb.append("\nCode: " + rs.getString("code"));
				sb.append("\nProduct Name: " + rs.getString("name"));
				sb.append("\nDescription: " + rs.getString("description"));
				sb.append("\nPrice: P" + rs.getString("price"));
				sb.append("\nHealth Benefits: " + rs.getString("healthbenefits") + "\n");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try{
				if(stmt!=null) {stmt.close();}
			}
			catch(Exception e) {}
			try{
				if(rs!=null) {rs.close();}
			}
			catch(Exception e) {}
		}
		return(sb.toString());
	}

	public boolean checkAccount(Connection conn, String user, String pass) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String checking = "Select username, password, status From tblCustomers where username = ? and password = ? and status = 'active'";
			stmt = conn.prepareStatement(checking);
			stmt.setString(1, user);
			stmt.setString(2, pass);
			rs = stmt.executeQuery();
			while(rs.next()) {
				return(true);
			}
		}
		catch(Exception e) {}
		finally {
			try{
				if(stmt!=null) {stmt.close();}
			}
			catch(Exception e) {}
			try{
				if(rs!=null) {rs.close();}
			}
			catch(Exception e) {}
		}
		return(false);
	}

	public boolean deleteAccount(Connection conn, String user, String pass) {
		PreparedStatement stmt = null;
		try {
			String deleteAccount = "Update tblCustomers set status ='deactive' where username = ? and password = ?";
			stmt = conn.prepareStatement(deleteAccount);
			stmt.setString(1, user);
			stmt.setString(2, pass);
			stmt.executeUpdate();
			return(true);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try{
				if(stmt!=null) {stmt.close();}
			}
			catch(Exception e) {}
		}
		return(false);
	}

	public boolean addAccount(Connection conn,String id, String pic, String user, String pass,String name, String add, String bday, String gen, String cont) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("Insert into tblCustomers(customerID, picture, username, password, fullname, address, birthday, gender, contact, status) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
			stmt.setString(1, id);
			stmt.setString(2, pic);
			stmt.setString(3, user);
			stmt.setString(4, pass);
			stmt.setString(5, name);
			stmt.setString(6, add);
			stmt.setString(7, bday);
			stmt.setString(8, gen);
			stmt.setString(9, cont);
			stmt.setString(10, "active");
			stmt.executeUpdate();
			return(true);
		}
		catch(Exception e) {}
		finally {
			try{
				if(stmt!=null) {stmt.close();}
			}
			catch(Exception e) {}
		}
		return(false);
	}

	public boolean addItem(Connection conn, String prod, String code, String pic, String n, String qty, String desc, String pr , String health, String type) {
		try {
			PreparedStatement stmt = conn.prepareStatement("Insert Into tblItems (productID, code, picture, name, quantity, description, price, healthbenefits, type) values (?, ?, ?, ?, ?, ?, ?, ?, ?);");
			stmt.setString(1, prod);
			stmt.setString(2, code);
			stmt.setString(3, pic);
			stmt.setString(4, n);
			stmt.setString(5, qty);
			stmt.setString(6, desc);
			stmt.setString(7, pr);
			stmt.setString(8, health);
			stmt.setString(9, type);
			stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return(true);
	}
}
