import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class BeverageServlet extends HttpServlet
{
	HealtheryDatabaseManager hdm;
	BeverageCollection bc;

	public void init() throws ServletException {
		hdm = HealtheryDatabaseManager.instance();
		bc = hdm.getMyBeverageCollection();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws
	ServletException, IOException {
		res.setContentType("text/xml");
		PrintWriter out = res.getWriter();
		BeverageDisplay(out);
	}

	public void BeverageDisplay(PrintWriter out) {
		StringBuilder sb = new StringBuilder("");
		sb.append("<BeverageList>");
		for(Beverage b : bc.getAllBeverages()) {
			sb.append("<Beverage>");
			sb.append("<ItemCode>" + b.getItemCode() + "</ItemCode>");
			sb.append("<Picture>" + b.getPicture() + "</Picture>");
			sb.append("<Name>" + b.getName() + "</Name>");
			sb.append("<Quantity>" + b.getQuantity() + "</Quantity>");
			sb.append("<Description>" + b.getDescription() + "</Description>");
			sb.append("<HealthBenefits>" + b.getHealthBenefits() + "</HealthBenefits>");
			sb.append("<Price>" + b.getPrice() + "</Price>");
			sb.append("<OrderCustomerID>" + b.getOrderCustomerID() + "</OrderCustomerID>");
			sb.append("<DeliverID>" + b.getDeliverID() + "</DeliverID>");
			sb.append("<Type>" + b.getType() + "</Type>");
			sb.append("</Beverage>");
		}
		sb.append("</BeverageList>");
		out.println(sb.toString());
	}

	public void destroy() {
		hdm = null;
		bc = null;
	}
}
