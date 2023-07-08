package assignment05;

import java.util.Calendar;
import java.util.concurrent.TimeUnit ;

public class MenuVisitor implements Visitor{
	
	int time,UpdateClosingHours;
	String ch,s="",subTime;
	
	public MenuVisitor(int UpdateClosingHours)
	{
		this.UpdateClosingHours=UpdateClosingHours;
	}

	// Change Closing Time
	@Override
	public void visit(Menu mi) {
		String OpeningHours = mi.getOpenHours();
		if(OpeningHours == null)
		{
			mi.setOpenHours("\nClosing 30 Minutes early than Usual");
		}
		else
		{
			int i = OpeningHours.indexOf("-");
			subTime = OpeningHours.substring(i);
			int j = subTime.indexOf("p");
			subTime = subTime.substring(2,j);
			
			String[] timeSplit = subTime.split(":");
			Calendar timeCal = Calendar.getInstance();
			timeCal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeSplit[0]));
			timeCal.set(Calendar.MINUTE, Integer.parseInt(timeSplit[1]));
			long timeMs = timeCal.getTimeInMillis();
			long timeToSubstract = 60000 * 30;
			long reducedTime = timeMs - timeToSubstract;
			Calendar calendar1 = Calendar.getInstance();
            calendar1.setTimeInMillis(reducedTime);
            int hrs = calendar1.get(Calendar.HOUR_OF_DAY);
            int min = calendar1.get(Calendar.MINUTE);
	        
	        subTime = " " +String.valueOf(hrs) + ":" + String.valueOf(min)+"pm";
	        String reducedTimes = OpeningHours.substring(0,i+1) + subTime;
			mi.setOpenHours(reducedTimes);
		}
	}
}
