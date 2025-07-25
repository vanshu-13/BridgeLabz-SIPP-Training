package ShoppingKart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart<T extends CartItem> {
	private List<T> items;
	
	public ShoppingCart() {
		items = new ArrayList<>();
	}
	
	public void addItem(T item) {
		items.add(item);
		System.out.println(item+" added to cart.\n");
	}
	
	public void removeItem(T item) {
		if(items.remove(item)) {
			System.out.println(item+" removed from cart.\n");
		}else {
			System.out.println(item+ " not found in cart.");
		}
	}
	
	public double calculateTotal() {
		double total = 0;
		for(T item : items) {
			total = item.getPrice()*item.getQuantity();
		}
		return total;
	}
	
	public void displayCart() {
		System.out.println("Cart Items: ");
		for(T item : items) {
			System.out.println(item);
		}
		System.out.println("+----------------------------+");
	}

}