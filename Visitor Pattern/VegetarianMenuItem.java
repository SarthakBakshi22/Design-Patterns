package assignment05;

public class VegetarianMenuItem extends MenuItem {
 
	public VegetarianMenuItem(String name, 
	                String description, 
	                double price) { 
		super(name, description, price);
	}
	public void accept(Visitor v) {
		v.visit(this);
	} 
}
