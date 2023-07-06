package assignment05;

import java.util.Iterator;

public abstract class MenuItem extends MenuComponent {
 
	private String name;
	private String description;
	private double price;
    
	public MenuItem(String nameIn, 
			String descriptionIn, double priceIn) { 
		name = nameIn;
		description = descriptionIn;
		price = priceIn;
	}
  
	public String getName() {
		return name;
	}
  
	public String getDescription() {
		return description;
	}
  
	public double getPrice() {
		return price;
	}
  
	public void setPrice(double newPrice) {
		price = newPrice;
	}

	public Iterator<MenuComponent> createIterator() {
		return new NullIterator();
	}
 
	public void print() {
		System.out.print("  " + getName());
		if (this instanceof VegetarianMenuItem) {
			System.out.print("(v)");
		}
		System.out.printf(", %.2f\n", getPrice());
		System.out.println("     -- " + getDescription());
	}

	public void accept(Visitor v) {
		v.visit(this);
	} 
}
