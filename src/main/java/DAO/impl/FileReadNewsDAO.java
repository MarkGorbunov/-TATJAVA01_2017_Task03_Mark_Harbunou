package DAO.impl;

import DAO.NewsDAO;
import DAO.exception.DAOException;
import beans.Category;
import beans.News;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Created by Mark_Harbunou on 1/30/2017.
 */
public class FileReadNewsDAO implements NewsDAO {
    Path pathToFile = Paths.get("E:/project/task3/NEWS.txt");


    @Override
    public void addNews(News news) throws DAOException {
        try (FileWriter fileWriter = new FileWriter(String.valueOf(pathToFile),true)) {
            fileWriter.write(String.valueOf(news.getCategory()) + " " + news.getTitle() + " " + news.getAuthor() + "\n");
        } catch (IOException | NullPointerException | IllegalArgumentException  e) {
            throw new DAOException();
        }
    }

    @Override
    public String findNews(News news) throws DAOException {
       // ArrayList<String> findedNews = new ArrayList<>();
        try {
            for (String line : Files.readAllLines(pathToFile, StandardCharsets.UTF_8)) {
                String[] argumentInTxt = line.split(" ");
                if (argumentInTxt[0].equalsIgnoreCase((news.getCategory().toString())) &&
                        argumentInTxt[1].equals(news.getTitle()) &&
                        argumentInTxt[2].equals(news.getAuthor())) {
                    return line;
                    //findedNews.add((String.valueOf(news.getCategory())) + " " + news.getTitle() + " " + news.getAuthor());
                }
            }
        } catch (IOException | NullPointerException |  java.lang.IllegalArgumentException  e) {
            throw new DAOException();
        }
        throw new DAOException();
    }










/*
    @Override
    public ArrayList<String> findNewsCategory(Category category) {
        ArrayList<String> addedNews = new ArrayList<>();
        Path pathToFile = Paths.get("C:/Users/Mark_Harbunou/IdeaProjects/NewsProtal1/NEWS.txt");
        try {
            List<String> lines = Files.readAllLines(pathToFile, StandardCharsets.UTF_8);
           for(String line :lines) {
               String[] argumentInTxt = line.split(" ");
               if(argumentInTxt[0].equals(category)) {
                   addedNews.add(line);
               }
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void findNewsTitle(String title) {

    }

    @Override
    public void findNewsAuthor(String author) {

    }
    */
}
