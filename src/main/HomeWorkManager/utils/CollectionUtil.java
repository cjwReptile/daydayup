package HomeWorkManager.utils;

import java.util.List;

public class CollectionUtil {

    public static boolean isEmpty(List<?> list){
        if(list==null||list.size()==0)
            return true;
        return false;
    }

    public static boolean isNotEmpty(List<?> list){
        if(list!=null&&list.size()!=0)
            return true;
        return false;
    }
}
