import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class MyCartServlet extends HttpServlet
{
	HealtheryDatabaseManager hdm;
	MyCartCollection bc;

	public void init() throws ServletException {
		hdm = HealtheryDatabaseManager.instance();
		bc = hdm.getMyCarCollection();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws
	ServletException, IOException {
		res.setContentType("text/xml");
		PrintWriter out = res.getWriter();
		MyCartDisplay(out);
	}

	public void MyCartDisplay(PrintWriter out) {
		StringBuilder sb = new StringBuilder("");
		sb.append("<MyCartList>");
		for(MyCart mc : bc.getAllCart()) {
			sb.append("<Cart>");
			sb.append("<CustomerCart>" + mc.getCustomerCart() + "</CustomerCart>");
			sb.append("<Code>" + mc.getItemCode() + "</Code>");
			sb.append("<Name>" + mc.getItemName() + "</Name>");
			sb.append("<Quantity>" + mc.getQuantity() + "</Quantity>");
			sb.append("<Price>" + mc.getPrice() + "</Price>");
			sb.append("</Cart>");
		}
		sb.append("</MyCartList>");
		out.println(sb.toString());
	}

	public void destroy() {
		hdm = null;
		bc = null;
	}
}
