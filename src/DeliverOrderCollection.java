import java.util.ArrayList;

public class DeliverOrderCollection
{

	private ArrayList<DeliverOrder> orders;
	private static DeliverOrderCollection _instance = null;

	public static DeliverOrderCollection instance() {
		if(_instance == null) {
			_instance = new DeliverOrderCollection();
		}
		return(_instance);
	}

	public DeliverOrderCollection() {
		orders = new ArrayList<DeliverOrder>();
	}

	public void addDeliverOrder(DeliverOrder ord) {
		orders.add(ord);
	}

	public void removeDeliverOrder(DeliverOrder acc) {
		orders.remove(acc);
	}

	public ArrayList<DeliverOrder> getAllDeliverOrder() {
		return(orders);
	}

	public DeliverOrder getIndexById(int acc) {
		return(orders.get(acc));
	}

	public int getDeliverOrderCount() {
		return(orders.size());
	}

	public ArrayList<DeliverOrder> deliverOrderSearch(String ord) {
		ArrayList<DeliverOrder> ordr = new ArrayList<DeliverOrder>();
		String ordSearch = ord.toLowerCase();
		for(DeliverOrder a: getAllDeliverOrder()) {
			if(search(a, ordSearch)) {
				ordr.add(a);
			}
		}
		return(ordr);
	}

	public boolean search(DeliverOrder a, String ordname) {
		String ordr = a.getFullName().toLowerCase();
		if(ordr.contains(ordname)) {
			return(true);
		}
		return(false);
	}
}
