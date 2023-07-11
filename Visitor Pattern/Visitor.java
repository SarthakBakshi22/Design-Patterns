package assignment05;

public interface Visitor {
	default void visit(MenuComponent mi) {} 
	default void visit(Menu m) {}
	default void visit(VegetarianMenuItem mi) {} 
	default void visit(NonVegetarianMenuItem mi) {} 
	default void visit(VeganMenuItem mi) {}
}
