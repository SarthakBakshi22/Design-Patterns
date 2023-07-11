package assignment05;

public class PriceVisitor implements Visitor{

	@Override
	public void visit(VegetarianMenuItem mi) {
		double d = mi.getPrice();
		mi.setPrice(d + 0.05);
	}

	@Override
	public void visit(NonVegetarianMenuItem mi) {
		double d = mi.getPrice();
		mi.setPrice(d + 0.10);
	}
	// Vegan price is unchanged
}
