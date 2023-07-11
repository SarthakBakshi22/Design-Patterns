package assignment05;

public class PriceVisitor1 implements Visitor{
	
	double nonVegetarianIncrease;
	double VegetarianIncrease;
	double VeganIncrease;
	
	public PriceVisitor1(double nonVegetarianIncrease, 
			double VegetarianIncrease, double VeganIncrease)
	{
		this.nonVegetarianIncrease= nonVegetarianIncrease;
		this.VegetarianIncrease= VegetarianIncrease;
		this.VeganIncrease= VeganIncrease;
	}

	// Change Non Veg Menu price by 
	@Override
	public void visit(NonVegetarianMenuItem mi) {
		double d = mi.getPrice();
		mi.setPrice(d + nonVegetarianIncrease);
	}
	
	// Change Veg Menu price by 
	@Override
	public void visit(VegetarianMenuItem mi) {
		double d = mi.getPrice();
		//System.out.println("Veg Item Price is: "+ d);
		mi.setPrice(d + VegetarianIncrease);
		//System.out.println("Veg Item Price After is: "+ (d + VegetarianIncrease));
	}
	
	//Vegan price is changed by
	@Override
	public void visit(VeganMenuItem mi) {
		double d = mi.getPrice();
		mi.setPrice(d + VeganIncrease);
	}
}
