package Date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


public class ToolDate {
    private static final long TO_MINUTE = 60;
    private static final long TO_HOUR = 3600;
    private static final long TO_DAY = 86400;
    private static final long TO_MONTH = 2628000;
    private static final long TO_YEAR = 31536000;

    public static LocalDate convertCurrentTimeMillisToLocalDate(long systemTimeMillis){
        return new Date(systemTimeMillis).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    public static LocalDateTime convertCurrentTimeMillisToLocalDateTime (long currentTimeMillis){
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(currentTimeMillis), ZoneId.systemDefault());
    }
    public static String timeAgo(long currentTimeMillis){
        long rangeTime = (System.currentTimeMillis() - currentTimeMillis)/1000;
        StringBuilder time = new StringBuilder();
        if(rangeTime >= TO_YEAR ){
            time.append(rangeTime/TO_YEAR);
            time.append(" year ago");
            return time.toString();
        }if(rangeTime >= TO_MONTH){
            time.append(rangeTime/TO_MONTH);
            time.append(" mon ago");
            return time.toString();
        }if(rangeTime >= TO_DAY){
            time.append(rangeTime/TO_DAY);
            time.append(" day ago");
            return time.toString();
        }if(rangeTime >= TO_HOUR){
            time.append(rangeTime/ TO_HOUR);
            time.append(" hou ago");
            return time.toString();
        }if(rangeTime >= TO_MINUTE){
            time.append(rangeTime/TO_MINUTE);
            time.append(" min ago");
        }else{
            time.append(rangeTime);
            time.append(" sec ago");
        }
        return time.toString();
    }
}
