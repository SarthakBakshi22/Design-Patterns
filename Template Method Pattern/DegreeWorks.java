package template-method-pattern;

import static assignment01.Gened.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public abstract class DegreeWorks {
	public boolean genedAudit(List<Course> courses) {
		boolean satisfied = false;

		satisfied = foreignLanguageAudit(courses);
		satisfied = checkC(courses) && checkO(courses) && satisfied;

		var iter = courses.iterator();
		while(iter.hasNext()) {
			var course = iter.next();
			course.geneds().remove(C); 
			course.geneds().remove(O); 
			course.geneds().remove(J); 
			course.geneds().remove(FL1); 
			course.geneds().remove(FL2); 
			course.geneds().remove(FL3); 

			if(course.geneds().size() == 0) iter.remove();
		}
		courses.sort(Comparator.comparingInt(course -> course.geneds().size()));

		var genedGroupList = new ArrayList<TreeSet<Gened>>(); 
		var t = new TreeSet<Gened>();
		genedGroupList.add(t);
		for(var c : courses) {
			
			var newList = new ArrayList<TreeSet<Gened>>();
			for(TreeSet<Gened> s : genedGroupList)
			{
				for(Gened g : c.geneds())
				{
					TreeSet<Gened> s1 = (TreeSet<Gened>) s.clone();					
					s1.add(g);
					newList.add(s1);
				}
			}
			genedGroupList = newList;
		}
		return checkGened(genedGroupList) && satisfied;		
	}
	public abstract boolean foreignLanguageAudit(List<Course> courses);
	
	public boolean checkC(List<Course> courses)
	{
		boolean ClistCheck = false;
		var iter = courses.iterator();
		while(iter.hasNext()) {
			var course = iter.next();
			if (course.geneds().contains(C) || course.geneds().contains(J))
			{
				ClistCheck=true;
			}
		}
		if (ClistCheck==false)
		{
			System.out.println("You still need a C or J course");
		}
		return ClistCheck;
	}
	
	public boolean checkO(List<Course> courses)
	{
		boolean OlistCheck = false;
		var iter = courses.iterator();
		while(iter.hasNext()) {
			var course = iter.next();
			if (course.geneds().contains(O) || course.geneds().contains(J))
			{
				OlistCheck=true;
			}
		}
		if (OlistCheck==false)
		{
			System.out.println("You still need a O or J course");
		}
		return OlistCheck;
	}
	
	public boolean checkGened(List<TreeSet<Gened>> genedGroupList)
	{	
		Set<Gened> set = Set.of(A, G, H, L, M, N, P, S, Y); 
		TreeSet<Gened> treeSet = new TreeSet<>(set);
		
		for (TreeSet<Gened> currSet :genedGroupList) {
			if(currSet.contains(B)) {
				currSet.remove(B);
				currSet.add(S);
				currSet.add(Y);
			}
			if(currSet.equals(treeSet)){
				return true;
			}
		}

		for(var g : Set.of(A, G, H, L, M, N, P, S, Y)) {
			boolean hasG = false;
			for(var grp : genedGroupList) {
				
				if(grp.contains(g)) hasG = true;				
			}
			if(!hasG) System.out.println("still need " + g + " course");
		}
		System.out.println("Most geneds do not double count, Please consult an advisor");
		return false;
	}
}
