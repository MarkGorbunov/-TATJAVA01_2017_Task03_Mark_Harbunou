package controller.impl;

import beans.Category;
import beans.News;
import controller.Command;
import service.impl.Converter;
import service.NewsService;
import service.exeption.ServiceException;
import service.factory.ServiceFactory;

/**
 * Created by Mark_Harbunou on 2/1/2017.
 */
public class FindNews implements Command {
    public String execute(String request) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsService newsService = serviceFactory.getNewsService();

        try {
            return newsService.findNews(request);
        } catch (ServiceException e) {
            return "News not found";
        }
    }
}
