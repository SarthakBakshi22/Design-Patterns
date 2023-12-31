package observer-pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Cell {
	protected String displayText;
	protected double value;
	protected boolean valueGiven; // false	
	protected Location location;
	protected SpreadSheet sheet;
	private List<FunctionCell> observers = new ArrayList<>();
	public Cell(Location loc, SpreadSheet spreadSheet) {
		location = loc;
		sheet = spreadSheet;
	}
	public void updateCell(String text, double val) {
		displayText = text;
		value = val;
		valueGiven = true;
		for(var cell : observers) cell.update();
	}
	public String getDisplayText() {
		return displayText;
	}
	public double getValue() {
		return value;
	}
	public boolean isValueGiven() {
		return valueGiven;
	}
	public Location getLocation() {
		return location;
	}
	public void clearCell() {
		displayText = null;
		value = 0.0;
		valueGiven = false;
//		for(var cell : observers) cell.update();
	}
	
	public void registerCell(FunctionCell cell) {
		observers.add(cell);
	}
	
	public void removeCell(FunctionCell cell) {
		observers.remove(cell);
	}
	public Set<Cell> getDependencies() {
		return null;
	}
	@Override
	public int hashCode() {
		return getLocation().hashCode();
	}
	@Override
	public boolean equals(Object obj) {
	 if (obj == null || !(obj instanceof Cell)) return false;
	 return getLocation().equals(((Cell)obj).getLocation());
	}
}
