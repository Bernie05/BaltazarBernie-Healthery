import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class CustomerServlet extends HttpServlet
{
	HealtheryDatabaseManager hdm;
	CustomerCollection gcc;

	public void init() throws ServletException {
		hdm = HealtheryDatabaseManager.instance();
		gcc = hdm.getCustomerCollection();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws
	ServletException, IOException {
		res.setContentType("text/xml");
		PrintWriter out = res.getWriter();
		CustomersDisplay(out);
	}

	public void CustomersDisplay(PrintWriter out) {
		StringBuilder sb = new StringBuilder("");
		sb.append("<CustomerList>");
		for(Customer c : gcc.getAllCustomers()) {
			sb.append("<customer>");
			sb.append("<customerID>" + c.getID() + "</customerID>");
			sb.append("<fullname>" + c.getFullName() + "</fullname>");
			sb.append("<address>" + c.getAddress() + "</address>");
			sb.append("<birthday>" + c.getBirthday() + "</birthday>");
			sb.append("<gender>" + c.getGender() + "</gender>");
			sb.append("<contact>" + c.getContactNo() + "</contact>");
			sb.append("</customer>");
		}
		sb.append("</CustomerList>");
		out.println(sb.toString());
	}

	public void destroy() {
		hdm = null;
		gcc = null;
	}
}
