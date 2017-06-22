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

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
