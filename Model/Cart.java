package Model;
import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<MenuItem> menuitemlist=new ArrayList<>();		//to save the cart items of the customer
	private double total;
	
	//getter and setter methods for the private variables;
	public List<MenuItem> getMenuitemlist() {
		return menuitemlist;
	}
	public void setMenuitemlist(List<MenuItem> menuitemlist) {
		this.menuitemlist = menuitemlist;
	}
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
}
