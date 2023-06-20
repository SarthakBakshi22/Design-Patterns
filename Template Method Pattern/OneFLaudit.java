package template-method-pattern;

import static template-method-pattern.Gened.*;
import java.util.List;


public class OneFLaudit extends DegreeWorks {

	@Override
	public boolean foreignLanguageAudit(List<Course> courses) {
		// TODO
		boolean FLsatisfied = false;
		var iter = courses.iterator();
		while(iter.hasNext()) {
			var course = iter.next();
			if(course.geneds().contains(FL1) || course.geneds().contains(FL2)
					|| course.geneds().contains(FL3))
			{
				System.out.println("Has FL: " + Resource.languageOf(course));
				return true;
			}
		}
		return FLsatisfied;
	}
}
