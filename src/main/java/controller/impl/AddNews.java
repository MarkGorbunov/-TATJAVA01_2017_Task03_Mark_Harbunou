package controller.impl;

import controller.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.NewsService;
import service.exeption.ServiceException;
import service.factory.ServiceFactory;

/**
 * Created by Mark_Harbunou on 2/1/2017.
 */
public class AddNews implements Command {
    static final Logger rootLogger = LogManager.getRootLogger();
    static final Logger addNewsLogger = LogManager.getLogger(AddNews.class);
    @Override
    public String execute(String request) {
        String responce = "";

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsService newsService = serviceFactory.getNewsService();

        try {
            newsService.addNews(request);
            responce = "book added";

            if (rootLogger.isDebugEnabled()) {
                rootLogger.debug("RootLogger: In debug message");
                addNewsLogger.debug("UserLogger in debug");
            }
        } catch (ServiceException e) {
           addNewsLogger.error("error message: " + e.getMessage());
            addNewsLogger.fatal("fatal error message: " + e.getMessage());
            responce = "error during addBook procedure";
        }
        return responce;
    }
}
