package assignment05;

public class NonVegetarianMenuItem extends MenuItem {
 
	public NonVegetarianMenuItem(String name, 
	                String description, 
	                double price) { 
		super(name, description, price);
	}
	public void accept(Visitor v) {
		v.visit(this);
	} 
}
