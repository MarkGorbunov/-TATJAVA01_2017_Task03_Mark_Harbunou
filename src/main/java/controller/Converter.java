package controller;

import beans.Category;
import controller.exception.ControllerException;

/**
 * Created by Mark_Harbunou on 2/1/2017.
 */
public class Converter {
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
