package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStampUtils {
    public static String getTimeStamp() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String timeStamp = formatter.format(date);
        return timeStamp;
    }
}
