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
				sb.append("\nContact: " + rs.getString("contact"));
				sb.append("\nOrder: " + rs.getString("myCart") + "\n");
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
			rs = stmt.executeQuery("SELECT * FROM tblProductOrder;");
			while(rs.next()) {
				sb.append("\nProduct Name: " + rs.getString("itemName"));
				sb.append("\nDescription :" + rs.getString("itemDescription"));
				sb.append("\nPrice: P" + rs.getString("itemPrice"));
				sb.append("\nHealth Benefits: " + rs.getString("itemHealthbenefits"));
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
			String checking = "Select username, password From tblCustomers where username = ? and password = ?";
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
			String deleteAccount = "Delete from tblCustomers where username = ? and password = ?";
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
			try{
				if(rs!=null) {rs.close();}
			}
			catch(Exception e) {}
		}
		return(false);
	}

	public boolean addAccount(Connection conn,String id, String pic, String user, String pass,String name, String add, String bday, String gen, String cont) {
		try {
			PreparedStatement stmt = conn.prepareStatement("Insert into tblCustomers(customerID, picture, username, password, fullname, address, birthday, gender, contact) values (?, ?, ?, ?, ?, ?, ?, ?, ?);");
			stmt.setString(1, id);
			stmt.setString(2, pic);
			stmt.setString(3, user);
			stmt.setString(4, pass);
			stmt.setString(5, name);
			stmt.setString(6, add);
			stmt.setString(7, bday);
			stmt.setString(8, gen);
			stmt.setString(9, cont);
			stmt.executeUpdate();
			return(true);
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

	public boolean addItem(Connection conn,String pic, String name, String description, String price, String health) {
		try {
			PreparedStatement stmt = conn.prepareStatement("Insert Into tblProductOrder (itemPicture, itemName, itemDescription, itemPrice, itemHealthbenefits) values (?, ?, ?, ?, ?);");
			stmt.setString(1, pic);
			stmt.setString(2, name);
			stmt.setString(3, description);
			stmt.setString(4, price);
			stmt.setString(5, health);
			stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return(true);
	}
}
