import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class DelivererServlet extends HttpServlet
{
	HealtheryDatabaseManager hdm;
	DeliverOrderCollection gdoc;

	public void init() throws ServletException {
		hdm = HealtheryDatabaseManager.instance();
		gdoc = hdm.getMyDeliverOrderCollection();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws
	ServletException, IOException {
		res.setContentType("text/xml");
		PrintWriter out = res.getWriter();
		DeliverDisplay(out);
	}

	public void DeliverDisplay(PrintWriter out) {
		StringBuilder sb = new StringBuilder("");
		sb.append("<DeliverList>");
		for(DeliverOrder mc : gdoc.getAllDeliverOrder()) {
			sb.append("<Deliver>");
			sb.append("<delivererID>" + mc.getID() + "</delivererID>");
			sb.append("<companyname>" + mc.getCompany() + "</companyname>");
			sb.append("<fullname>" + mc.getFullName() + "</fullname>");
			sb.append("<address>" + mc.getAddress() + "</address>");
			sb.append("<birthday>" + mc.getBirthday() + "</birthday>");
			sb.append("<gender>" + mc.getGender() + "</gender>");
			sb.append("<contactNo>" + mc.getContactNo() + "</contactNo>");
			sb.append("</Deliver>");
		}
		sb.append("</DeliverList>");
		out.println(sb.toString());
	}

	public void destroy() {
		hdm = null;
		gdoc = null;
	}
}
