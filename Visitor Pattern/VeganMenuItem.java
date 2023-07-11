package assignment05;

public class VeganMenuItem extends MenuItem {
 
	public VeganMenuItem(String name, 
	                String description, 
	                double price) { 
		super(name, description, price);
	}
	public void accept(Visitor v) {
		v.visit(this);
	} 
}
