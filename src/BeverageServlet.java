import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class BeverageServlet extends HttpServlet
{
	HealtheryDatabaseManager hdm;
	ItemCollection bc;

	public void init() throws ServletException {
		hdm = HealtheryDatabaseManager.instance();
		bc = hdm.getItemCollection();
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
		for(Items i : bc.getAllItems()) {
			if(i instanceof Beverage) {
				Beverage bvg = (Beverage)i;
				sb.append("<Beverage>");
				sb.append("<ItemCode>" + bvg.getItemCode() + "</ItemCode>");
				sb.append("<Picture>" + bvg.getPicture() + "</Picture>");
				sb.append("<Name>" + bvg.getName() + "</Name>");
				sb.append("<Quantity>" + bvg.getQuantity() + "</Quantity>");
				sb.append("<Description>" + bvg.getDescription() + "</Description>");
				sb.append("<HealthBenefits>" + bvg.getHealthBenefits() + "</HealthBenefits>");
				sb.append("<Price>" + bvg.getPrice() + "</Price>");
				sb.append("<Type>" + bvg.getType() + "</Type>");
				sb.append("</Beverage>");
			}
		}
		sb.append("</BeverageList>");
		out.println(sb.toString());
	}

	public void destroy() {
		hdm = null;
		bc = null;
	}
}
