package assignment01;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public record Course(int semester, int crn, String number, 
		Set<Gened> geneds) {
	public Course(int semesterIn, int crnIn, String numberIn, 
			Gened... genedsIn) {
		this(semesterIn, crnIn, numberIn,
				new TreeSet<>(Arrays.asList(genedsIn)));
	}
	@Override
	public String toString() {
		return "Course " + number;
	}
}
