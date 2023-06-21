package template-method-pattern;

import java.util.List;

public class ZeroFLaudit extends DegreeWorks {

	@Override
	public boolean foreignLanguageAudit(List<Course> courses) {
		return true;
	}

}
