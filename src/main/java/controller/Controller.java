package controller;

import controller.exception.ControllerException;

/**
 * Created by Mark_Harbunou on 2/1/2017.
 */
public class Controller {
    private final CommandProvider provider = new CommandProvider();
    private final char paramDelimeter = ' ';
    public String executeTask(String request) throws ControllerException {
        String commandName;
        Command executionCommand;
        commandName = request.substring(0, request.indexOf(paramDelimeter));
        executionCommand = provider.getCommand(commandName);
        String response;
        response = executionCommand.execute(request);
        return response;
    }
}
