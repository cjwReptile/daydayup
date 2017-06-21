package ssm.dto;

/**
 * Created by cjw on 2017/6/21.
 * 返回json数据
 */
public class SecKillResult<T> {

      private boolean success;

      private T data;

      private String error;
      /**
       *秒杀成功
       */
      public SecKillResult(boolean success, T data) {
        this.success = success;
        this.data = data;
      }
     /**
      *秒杀失败返回
      */
    public SecKillResult(boolean success, String error) {
        this.success = success;
        this.error = error;
    }
}
