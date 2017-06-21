package ssm.Exceptions;

/**
 * Created by cjw on 2017/6/21.
 */
public class RepeatSecKillException extends SecKillException{


    public RepeatSecKillException(String message) {
        super(message);
    }

    public RepeatSecKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
