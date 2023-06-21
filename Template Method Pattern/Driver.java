package template-method-pattern;

import static template-method-pattern.Gened.*;

import java.util.List;

public class Driver {

	public static void main(String[] args) {
		DegreeWorks test = new FullFLaudit();
		List<Course> list = Resource.getCourses();
		int count = 1;
		System.out.println("Full Audit test");
		for(var c : list) {
			System.out.println(count++ + ". " + c + ", geneds: " + c.geneds());
			if(c.geneds().contains(FL1) || c.geneds().contains(FL2)
					|| c.geneds().contains(FL3)
					) System.out.println(c.number() + " -> " + Resource.languageOf(c));
		}
		System.out.println(test.genedAudit(list));
		System.out.println("=========================");
		
		test = new OneFLaudit();
		list = Resource.getCourses();
		count = 1;
		System.out.println("One FL Audit test");
		for(var c : list) {
			System.out.println(count++ + ". " + c + ", geneds: " + c.geneds());
			if(c.geneds().contains(FL1) || c.geneds().contains(FL2)
					|| c.geneds().contains(FL3)
					) System.out.println(c.number() + " -> " + Resource.languageOf(c));
		}
		System.out.println(test.genedAudit(list));
		System.out.println("=========================");
		
		test = new ZeroFLaudit();
		list = Resource.getCourses();
		count = 1;
		System.out.println("Zero FL Audit test");
		for(var c : list) {
			System.out.println(count++ + ". " + c + ", geneds: " + c.geneds());
			if(c.geneds().contains(FL1) || c.geneds().contains(FL2)
					|| c.geneds().contains(FL3)
					) System.out.println(c.number() + " -> " + Resource.languageOf(c));
		}
		System.out.println(test.genedAudit(list));
	}

}
