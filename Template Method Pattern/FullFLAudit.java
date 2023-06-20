package template-method-pattern;

import static template-method-pattern.Gened.*;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FullFLaudit extends DegreeWorks {

	@Override
	public boolean foreignLanguageAudit(List<Course> courses) {
		boolean FullFLsatisfied = false;
		Set<String> langNames = new TreeSet<>();
		var iter = courses.iterator();
		while(iter.hasNext()) {
			var course = iter.next();
			if(course.geneds().contains(FL3))
			{
				System.out.println("Has FL3: " + Resource.languageOf(course));
				FullFLsatisfied=true;
			}
			else if(course.geneds().contains(FL2))
			{
				langNames.add(Resource.languageOf(course));
			}
		}
		if (FullFLsatisfied == false)
			System.out.println("NO FL3: ");
		if (langNames.size() > 1)
			System.out.println("Has FL2 in 2 different languages: " + langNames);
		else if(FullFLsatisfied == false && langNames.size() <=1)
			System.out.println("does not have FL2 in different languages");
		    FullFLsatisfied = true;
		
		return FullFLsatisfied;
	}

}
