package HomeWorkManager.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * Created by cjw on 2017/12/14.
 */
public class PropertiesUtil {

    private   volatile  Properties properties=null;
    public PropertiesUtil(String fileUrl){
        readProperties(fileUrl);
    }


    public void readProperties(String fileUrl){
       if(properties==null){
           synchronized (PropertiesUtil.class){
               if(properties==null){
                   properties=new Properties();

                   try {
                       InputStreamReader isr=new InputStreamReader(
                               getClass().getResourceAsStream(fileUrl),"utf-8");
                       properties.load(isr);
                   } catch (UnsupportedEncodingException e) {
                       e.printStackTrace();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }

               }


           }
       }
    }

    public  String getValue(String key){
        return properties.getProperty(key);
    }
}
