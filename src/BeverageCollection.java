import java.util.ArrayList;

public class BeverageCollection
{
	private static BeverageCollection _instance = null;
	private ArrayList<Beverage> beverages;

	public static BeverageCollection instance() {
		if(_instance == null) {
			_instance = new BeverageCollection();
		}
		return(_instance);
	}

	public BeverageCollection() {
		beverages = new ArrayList<Beverage>();
	}

	public void addBeverage(Beverage b) {
		beverages.add(b);
	}

	public void removeBeverage(Beverage b) {
		beverages.remove(b);
	}

	public ArrayList<Beverage> getAllBeverages() {
		return(beverages);
	}

	public Beverage getAllBeveragesByIndex(int n) {
		return(beverages.get(n));
	}

	public int getBeveragesCount() {
		return(beverages.size());
	}

	public ArrayList<Beverage> beverageSearch(String item) {
		ArrayList<Beverage> bv = new ArrayList<Beverage>();
		String itemSearch = item.toLowerCase();
		for(Beverage b : getAllBeverages()) {
			if(search(b, itemSearch)) {
				bv.add(b);
			}
		}
		return(bv);
	}

	public boolean search(Beverage b, String n) {
		String beverage = b.getName().toLowerCase();
		if(beverage.contains(n)) {
			return(true);
		}
		return(false);
	}
}
