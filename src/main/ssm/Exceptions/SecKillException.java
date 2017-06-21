package ssm.Exceptions;

/**
 * Created by cjw on 2017/6/21.
 */
public class SecKillException extends RuntimeException{
    public SecKillException(String message) {
        super(message);
    }

    public SecKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
