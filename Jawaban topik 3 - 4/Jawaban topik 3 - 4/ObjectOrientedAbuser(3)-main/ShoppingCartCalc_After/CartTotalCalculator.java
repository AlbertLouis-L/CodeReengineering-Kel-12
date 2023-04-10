import java.util.ArrayList;
import java.util.List;

public class CartTotalCalculator {
	
	private List<Item> items;
	private double totalPrice;
	
	public CartTotalCalculator(List<Item> items) {
		this.items = items;
		this.totalPrice = 0.0;
		
		// calculate total price
		for (Item item : items) {
			totalPrice += item.getPrice();
		}
	}
	
	public void updateTotalPrice(double price) {
		totalPrice += price;
	}
	
	public void getTotalPrice() {
		return totalPrice;
	}
}
