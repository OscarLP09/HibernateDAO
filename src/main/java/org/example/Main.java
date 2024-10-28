package org.example;

import org.example.dao.GameDAO;
import org.example.dao.UserDAO;
import org.example.models.Game;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        var dao = new GameDAO(HibernateUtil.getSessionFactory());
        var userDAO = new UserDAO(HibernateUtil.getSessionFactory());

        var user = userDAO.validateUser("oscar@cesur.com", "1234");

        System.out.println(user);


    }
}