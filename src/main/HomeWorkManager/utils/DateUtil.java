package HomeWorkManager.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static Logger logger=LoggerFactory.getLogger(DateUtil.class);


    public static String formatDate(String format, Date date){
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        try {
            String result=sdf.format(date);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }


}
