package assignment05;

import java.util.Iterator;

public class MenuTestDrive {
	
	
	private static void doVisitor(Waiter waiter, Visitor visitor,Iterator<MenuComponent> iter)
	{
	    while(iter.hasNext()) 
	    {
	        MenuComponent mc = iter.next();
	        mc.accept(visitor);
	    }
	    waiter.printMenu();
	}
	
	
	public static void main(String args[]) {

		MenuComponent pancakeHouseMenu = 
				new Menu("PANCAKE HOUSE MENU", "Breakfast");
		pancakeHouseMenu.setOpenHours("7:00am - 2:00pm");
		
		MenuComponent dinerMenu = 
				new Menu("DINER MENU", "Lunch");
		dinerMenu.setOpenHours("10:30am - 3:00pm");

		MenuComponent cafeMenu = 
				new Menu("CAFE MENU", "Dinner");
		cafeMenu.setOpenHours("4:00pm - 10:30pm");
		
		MenuComponent dessertMenu = 
				new Menu("DESSERT MENU", "Dessert of course!");

		MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");

		allMenus.add(pancakeHouseMenu);
		allMenus.add(dinerMenu);
		allMenus.add(cafeMenu);

		pancakeHouseMenu.add(new VegetarianMenuItem(
				"K&B's Pancake Breakfast", 
				"Pancakes with scrambled eggs and toast", 
				2.99));
		pancakeHouseMenu.add(new NonVegetarianMenuItem(
				"Regular Pancake Breakfast", 
				"Pancakes with fried eggs, sausage", 
				2.99));
		pancakeHouseMenu.add(new VeganMenuItem(
				"Vegan Blueberry Pancakes",
				"Vegan Pancakes made with fresh blueberries and blueberry syrup",
				3.49));
		pancakeHouseMenu.add(new VegetarianMenuItem(
				"Waffles",
				"Waffles with your choice of blueberries or strawberries",
				3.59));

		dinerMenu.add(new VegetarianMenuItem(
				"Vegetarian BLT",
				"(Fakin') Bacon with lettuce & tomato on whole wheat", 
				2.99));
		dinerMenu.add(new NonVegetarianMenuItem(
				"BLT",
				"Bacon with lettuce & tomato on whole wheat", 
				2.99));
		dinerMenu.add(new VegetarianMenuItem(
				"Vegetarian Soup of the day",
				"A bowl of the soup of the day, with a side of potato salad", 
				3.29));
		dinerMenu.add(new NonVegetarianMenuItem(
				"Meat stock based soup of the day",
				"A bowl of the soup of the day, with a side of potato salad", 
				3.29));
		dinerMenu.add(new NonVegetarianMenuItem(
				"Hot Dog",
				"A hot dog, with saurkraut, relish, onions, topped with cheese",
				3.05));
		dinerMenu.add(new VeganMenuItem(
				"Steamed Veggies and Brown Rice",
				"A medly of steamed vegetables over brown rice", 
				3.99));

		dinerMenu.add(new VeganMenuItem(
				"Pasta",
				"Spaghetti with vegan marinara sauce, and a slice of sourdough bread",
				3.89));

		dinerMenu.add(dessertMenu);

		dessertMenu.add(new VegetarianMenuItem(
				"Apple Pie",
				"Apple pie with a flakey crust, topped with vanilla icecream",
				1.59));
		dessertMenu.add(new VegetarianMenuItem(
				"Cheesecake",
				"Creamy New York cheesecake, with a chocolate graham crust",
				1.99));
		dessertMenu.add(new VeganMenuItem(
				"Sorbet",
				"A scoop of raspberry and a scoop of lime",
				1.89));

		cafeMenu.add(new VegetarianMenuItem(
				"Veggie Burger and Air Fries",
				"Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
				3.99));
		cafeMenu.add(new NonVegetarianMenuItem(
				"Soup of the day",
				"A cup of the soup of the day, with a side salad",
				3.69));
		cafeMenu.add(new VeganMenuItem(
				"Burrito",
				"A large burrito, with whole pinto beans, salsa, guacamole",
				4.29));

//		Waiter waiter = new Waiter(allMenus);
//
//		//waiter.printVegetarianMenu();
//		waiter.printMenu();
//
//		Visitor v = new PriceVisitor();
//		Iterator<MenuComponent> iter = allMenus.createIterator();
//		while(iter.hasNext()) {
//			MenuComponent mc = iter.next();
//			mc.accept(v);
//		}
	    Waiter waiter = new Waiter(allMenus);
	    waiter.printMenu();
	    // ... are the parameters you will choose:

	   doVisitor(waiter, new PriceVisitor1(0.5,3.2,1.5), allMenus.createIterator());
	   doVisitor(waiter, new PriceVisitor2(15.0), allMenus.createIterator());
	   doVisitor(waiter, new MenuVisitor(30), allMenus.createIterator());

	}
}
