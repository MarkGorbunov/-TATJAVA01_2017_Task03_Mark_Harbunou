package service.impl;

import beans.Category;
import beans.News;
import service.exeption.ServiceException;

/**
 * Created by Mark_Harbunou on 2/1/2017.
 */
public class Converter {

     public Category findCategory(String request) throws ServiceException {
        String[] splittedRequest =  request.split(" ");
        for(Category category : Category.values()) {
            if(splittedRequest[1].toUpperCase().equals(category.toString())) {
                return category;
            }
        }
         throw new ServiceException();
    }

}
