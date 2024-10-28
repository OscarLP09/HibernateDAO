package org.example;

import org.example.dao.GameDAO;
import org.example.models.Game;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        var dao = new GameDAO(HibernateUtil.getSessionFactory());
        var game = new Game();

        game = dao.findAll().getLast();

        game.setYear(2222);
        dao.delete(game);


    }
}