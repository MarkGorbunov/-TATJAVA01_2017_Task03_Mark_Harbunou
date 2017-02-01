package controller.exception;

/**
 * Created by Mark_Harbunou on 2/1/2017.
 */
public class ControllerException extends Exception {
    public ControllerException() {
        super();
    }

    public ControllerException(String message) {
        super(message);
    }

    public ControllerException(Exception e) {
        super(e);
    }

    public ControllerException(String message, Exception e) {
        super(message, e);
    }
}

