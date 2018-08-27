package HomeWorkManager.enity.Integrate;

/**
 * 通用ajax返回实体(前后端分离规范版)
 * Created by liuzhenghong on 2017/8/26.
 */
public class ReturnEntity {

    private Object data;                    //返回数据
    private int status;                     //状态值(0:成功, 1~Integer.Max:错误码)
    private StatusInfo statusInfo;          //错误信息实体

    public static ReturnEntity SUCCESS = new ReturnEntity();
    public static ReturnEntity FAIL = new ReturnEntity(1, "系统错误");

    public ReturnEntity(){
        this.status = 0;
    }
    public ReturnEntity(Object data) {
        this.data = data;
        this.status = 0;
        this.statusInfo = null;
    }
    public ReturnEntity(int status, String errorMsg) {
        this.status = status;
        this.statusInfo = new StatusInfo(errorMsg, null);
    }
    public ReturnEntity(int status, String errorMsg, Object debug) {
        this.status = status;
        this.statusInfo = new StatusInfo(errorMsg, debug);
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public StatusInfo getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(StatusInfo statusInfo) {
        this.statusInfo = statusInfo;
    }

    public static class StatusInfo{
        private String message;             //显示可页面提示内容
        private Object detail;              //调试信息(eg: exception.getMessage())

        public StatusInfo(String message) {
            this.message = message;
        }
        public StatusInfo(String message, Object detail) {
            this.message = message;
            this.detail = detail;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Object getDetail() {
            return detail;
        }

        public void setDetail(Object detail) {
            this.detail = detail;
        }
    }
}
