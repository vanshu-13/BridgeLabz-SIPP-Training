package ShoppingKart;

class Item implements CartItem {
	
	private String name;
	private int quantity;
	private double price;
	
	public Item(String name, int quantity, double price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
	@Override
	
	public double getPrice() { 
		return price;
		}
	
	@Override
	
	public int getQuantity() {
		return quantity;
		}
	
	@Override
	
	public void setPrice(double price) { 
		this.price = price;
		}
	
	public String toString() {
		return "Item: " + name + "(Qyt: "+ quantity + " ,Price: "+ price +")";
	}
}