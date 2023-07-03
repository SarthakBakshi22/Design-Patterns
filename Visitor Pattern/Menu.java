package assignment05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu extends MenuComponent {
	private Iterator<MenuComponent> iterator = null;
	private List<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
	private String name;
	private String description;
	private String openHours; // null
  
	public Menu(String name, String description) {
		this.name = name;
		this.description = description;
	}
 
	public void add(MenuComponent menuComponent) {
		menuComponents.add(menuComponent);
	}
 
	public void remove(MenuComponent menuComponent) {
		menuComponents.remove(menuComponent);
	}
 
	public MenuComponent getChild(int i) {
		return menuComponents.get(i);
	}
 
	public String getName() {
		return name;
	}
 
	public String getDescription() {
		return description;
	}

	public String getOpenHours() {
		return openHours;
	}
	
	public void setOpenHours(String hours) {
		openHours = hours;
	}
	
	public Iterator<MenuComponent> createIterator() {
	    return new CompositeIterator(menuComponents.iterator());

//	    if (iterator == null) {
//	        iterator = new CompositeIterator(menuComponents.iterator());
//	    }
//	    return iterator;
	}
 
	public void accept(Visitor v) {
		v.visit(this);
	}
 
	public void print() {
		System.out.print("\n" + getName());
		System.out.println(", " + getDescription());
		if(getOpenHours() != null) 
			System.out.println("Open " + getOpenHours());
		System.out.println("---------------------");
  
		Iterator<MenuComponent> iterator = menuComponents.iterator();
		while (iterator.hasNext()) {
			MenuComponent menuComponent = iterator.next();
			menuComponent.print();
		}
	}
}
