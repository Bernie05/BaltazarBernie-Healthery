import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class AllProductServlet extends HttpServlet
{
	HealtheryDatabaseManager hdm;
	ItemCollection ic;

	public void init() throws ServletException {
		hdm = HealtheryDatabaseManager.instance();
		ic = ItemCollection.instance();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws
	ServletException, IOException {
		res.setContentType("text/xml");
		PrintWriter out = res.getWriter();
			AllProduct(out);
	}

	public void AllProduct(PrintWriter out) {
		StringBuilder sb = new StringBuilder("");
		sb.append("<AllItems>");
		for(Items b : ic.getAllItems()) {
			sb.append("<Item>");
			sb.append("<ItemCode>" + b.getItemCode() + "</ItemCode>");
			sb.append("<Picture>" + b.getPicture() + "</Picture>");
			sb.append("<Name>" + b.getName() + "</Name>");
			sb.append("<Quantity>" + b.getQuantity() + "</Quantity>");
			sb.append("<Description>" + b.getDescription() + "</Description>");
			sb.append("<HealthBenefits>" + b.getHealthBenefits() + "</HealthBenefits>");
			sb.append("<Price>" + b.getPrice() + "</Price>");
			sb.append("<Type>" + b.getType() + "</Type>");
			sb.append("</Item>");
		}
		sb.append("</AllItems>");
		out.println(sb.toString());
	}

	public void destroy() {
		hdm = null;
		ic = null;
	}
}
