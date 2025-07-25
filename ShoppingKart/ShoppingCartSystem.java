package ShoppingKart;

public class ShoppingCartSystem {
	public static void main(String args[]) {
		ShoppingCart<Item> cart1 = new ShoppingCart<>();
		cart1.addItem(new Item("Laptop", 1, 55000));
		cart1.addItem(new Item("Keyboard", 2, 1500));
		cart1.addItem(new Item("Mouse", 1, 2500));
		cart1.displayCart();
		System.out.println("Total price: $"+cart1.calculateTotal());
		
		System.out.println("+------------------------------------------+");
		
		ShoppingCart<Book> cart2 = new ShoppingCart<>();
		cart2.addItem(new Book("RD Sharma", 1, 1000));
		cart2.addItem(new Book("Java Programming", 2, 1500));
		cart2.displayCart();
		System.out.println("Total price: $"+cart2.calculateTotal());
	}
}