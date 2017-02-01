package controller.impl;

import beans.Category;
import beans.News;
import controller.Command;
import controller.exception.ControllerException;
import service.NewsService;
import service.exeption.ServiceException;
import service.factory.ServiceFactory;

/**
 * Created by Mark_Harbunou on 2/1/2017.
 */
public class FindNews implements Command {
    public String execute(String request) throws ControllerException {

        String[] splittedRequest =  request.split(" ");
        Category category = findCategory(request);
        String title = splittedRequest[2];
        String author = splittedRequest[3];

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsService newsService = serviceFactory.getNewsService();

        try {
            return newsService.findNews(new News(category,title,author));
        } catch (ServiceException e) {
          return "some error during news founding process";
        }
    }

    private Category findCategory(String request) throws ControllerException {
        String[] splittedRequest =  request.split(" ");
        for(Category category : Category.values()) {
            if(splittedRequest[1].equals(category.toString())) {
                return category;
            }
        }
        throw new ControllerException();
    }
}
