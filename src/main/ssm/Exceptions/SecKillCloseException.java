package ssm.Exceptions;

/**
 * Created by cjw on 2017/6/21.
 */
public class SecKillCloseException extends SecKillException{
    public SecKillCloseException(String message) {
        super(message);
    }

    public SecKillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
