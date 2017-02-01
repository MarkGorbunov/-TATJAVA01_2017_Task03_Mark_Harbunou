import controller.Controller;
import controller.exception.ControllerException;

public class Main {

    public static void main(String[] args) throws ControllerException {
        Controller controller = new Controller();
        controller.executeTask("ADD_NEWS books life Mark");
        controller.executeTask("ADD_NEWS BOOKS life Mark1");
        controller.executeTask("ADD_NEWS BOOKS life Mark2");
	// write your code here
    }
}
