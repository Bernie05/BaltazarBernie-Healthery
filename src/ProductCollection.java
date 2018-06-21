import java.util.ArrayList;

public class ProductCollection
{
	private ArrayList<Product> products;
	private static ProductCollection _instance = null;

	public static ProductCollection instance() {
		if(_instance == null) {
			_instance = new ProductCollection();
		}
		return(_instance);
	}

	public ProductCollection() {
		products = new ArrayList<Product>();
	}

	public void addProduct(Product p) {
		products.add(p);
	}

	public void removeProduct(Product p) {
		products.remove(p);
	}

	public ArrayList<Product> getAllProducts() {
		return(products);
	}

	public Product getProductByIndex(int n) {
		return(products.get(n));
	}

	public int getProductCount() {
		return(products.size());
	}

	public ArrayList<Product> productSearch(String item) {
		ArrayList<Product> pr = new ArrayList<Product>();
		String itemSearch = item.toLowerCase();
		for(Product p : getAllProducts()) {
			if(search(p, itemSearch)) {
				pr.add(p);
			}
		}
		return(pr);
	}

	public boolean search(Product p, String pname) {
		String products = p.getName().toLowerCase();
		if(products.contains(pname)) {
			return(true);
		}
		return(false);
	}
}
