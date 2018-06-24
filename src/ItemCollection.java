import java.util.ArrayList;

public class ItemCollection
{
	private ArrayList<Items> items;
	private static ItemCollection _instance = null;

	public static ItemCollection instance() {
		if(_instance == null) {
			_instance = new ItemCollection();
		}
		return(_instance);
	}

	private ItemCollection() {
		items = new ArrayList<Items>();
	}

	public void addItem(Items i) {
		items.add(i);
	}

	public void removeItem(Items i) {
		items.remove(i);
	}

	public ArrayList<Items> getAllItems() {
		return(items);
	}

	public Items getIndexById(int i) {
		return(items.get(i));
	}

	public int getAllItemCount() {
		return(items.size());
	}

	public ArrayList<Items> itemSearch(String item) {
		ArrayList<Items> itm = new ArrayList<Items>();
		String itemSearch = item.toLowerCase();
		for(Items i : getAllItems()) {
			if(search(i, itemSearch)) {
				itm.add(i);
			}
		}
		return(itm);
	}

	public boolean search(Items i, String item) {
		String it = i.getName().toLowerCase();
		if(it.contains(item)) {
			return(true);
		}
		return(false);
	}
}
