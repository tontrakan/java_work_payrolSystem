
package Core;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class currentData {
    
    public void calender(){
        Calendar cal = new GregorianCalendar();
        int months = cal.get(Calendar.MONTH);
        int years = cal.get(Calendar.YEAR);
        int Days = cal.get(Calendar.DAY_OF_MONTH);
    }
}
