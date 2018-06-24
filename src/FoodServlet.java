import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class FoodServlet extends HttpServlet
{
	HealtheryDatabaseManager hdm;
	ItemCollection fc;

	public void init() throws ServletException {
		hdm = HealtheryDatabaseManager.instance();
		fc = hdm.getItemCollection();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws
	ServletException, IOException {
		res.setContentType("text/xml");
		PrintWriter out = res.getWriter();
		FoodDisplay(out);
	}

	public void FoodDisplay(PrintWriter out) {
		StringBuilder sb = new StringBuilder("");
		sb.append("<ProductList>");
		for(Items i : fc.getAllItems()) {
			if(i instanceof Food) {
				Food fd = (Food)i;
				sb.append("<Food>");
				sb.append("<ItemCode>" + fd.getItemCode() + "</ItemCode>");
				sb.append("<Picture>" + fd.getPicture() + "</Picture>");
				sb.append("<Name>" + fd.getName() + "</Name>");
				sb.append("<Quantity>" + fd.getQuantity() + "</Quantity>");
				sb.append("<Description>" + fd.getDescription() + "</Description>");
				sb.append("<HealthBenefits>" + fd.getHealthBenefits() + "</HealthBenefits>");
				sb.append("<Price>" + fd.getPrice() + "</Price>");
				sb.append("<Type>" + fd.getType() + "</Type>");
				sb.append("</Food>");
			}
		}
		sb.append("</ProductList>");
		out.println(sb.toString());
	}

	public void destroy() {
		hdm = null;
		fc = null;
	}
}
