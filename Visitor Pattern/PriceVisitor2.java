package assignment05;

public class PriceVisitor2 implements Visitor{
	
	double percentIncrease;
	
	public PriceVisitor2(double percentIncrease)
	{
		this.percentIncrease= percentIncrease;
	}

	// Change Non Veg Menu price by x Percent 
	@Override
	public void visit(NonVegetarianMenuItem mi) {
		double d = mi.getPrice();
		mi.setPrice(d + (d*percentIncrease/100));
	}
	
	// Change Veg Menu price by x Percent
	@Override
	public void visit(VegetarianMenuItem mi) {
		double d = mi.getPrice();
		mi.setPrice(d + (d*percentIncrease/100));
	}
	
	//Vegan price is changed by x Percent
	@Override
	public void visit(VeganMenuItem mi) {
		double d = mi.getPrice();
		mi.setPrice(d + (d*percentIncrease/100));
	}
}
