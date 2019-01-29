package exception;

/**
 * @BelongsProject: SSMtest
 * @BelongsPackage: exception
 * @Author: yang
 * @CreateTime: 2019-01-23 15:33
 * @Description: ${Description}
 */
public class CustomException extends Exception {
    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //异常信息
    public String message;

    public CustomException(String message){
        super(message);
        this.message=message;
    }
}
