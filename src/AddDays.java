import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by dt8841 on 8/19/14.
 */
public class AddDays {

    public static void main(String args[]){

        SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yy");
        Date startDay = null;
        Date endDay = null;

        try {
             startDay = date.parse(args[0]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
             endDay = date.parse(args[1]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(startDay);
        Date thisDate = c.getTime();
        int startUniqueId = Integer.parseInt(args[2]);

        while(!(thisDate.equals(endDay))){
            startUniqueId++;
            System.out.println("insert into PIPELINE_STATUS (ID, PIPELINE, BUCKET_TS, STATUS, LAST_RUN_BEG_TS, LAST_RUN_END_TS, LAST_RUN_WF_ID) \n" +
                    "values('"+startUniqueId+"','marchex-data','"+  date.format(thisDate).toUpperCase()+"','SUCCEEDED','','' ,'' );\n");
            c.add(Calendar.DATE, 1);
            thisDate = c.getTime();
        }
    }
}
