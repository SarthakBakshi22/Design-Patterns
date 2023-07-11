package assignment05;

import java.util.Iterator;
  
public class Waiter {
	MenuComponent allMenus;
 
	public Waiter(MenuComponent allMenus) {
		this.allMenus = allMenus;
	}
 
	public void printMenu() {
		allMenus.print();
	}
  
	public void printVegetarianMenu() {
		Iterator<MenuComponent> iterator = allMenus.createIterator();

		System.out.println("\nVEGETARIAN MENU\n----");
		while (iterator.hasNext()) {
			MenuComponent menuComponent = iterator.next();
			try {
				if (menuComponent instanceof VegetarianMenuItem ||
						menuComponent instanceof VeganMenuItem) {
					menuComponent.print();
				}
			} catch (UnsupportedOperationException e) {}
		}
	}
}
