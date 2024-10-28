package org.example.dao;

import org.example.models.Game;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class GameDAO implements DAO<Game> {

    private SessionFactory sessionFactory;

    public GameDAO(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Game> findAll() {
        try(Session session = sessionFactory.openSession()) {
            return session.createQuery("select g from Game g",Game.class).list();
        } catch (Exception e) {
            return new ArrayList<Game>(0);
        }
    }

    @Override
    public Game findById(Long id) {
        try(Session session = sessionFactory.openSession()) {
            return session.get(Game.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void save(Game game) {

        sessionFactory.inTransaction( session -> session.persist(game) );
    }

    @Override
    public void update(Game game) {

        sessionFactory.inTransaction( session -> session.merge(game) );
    }

    @Override
    public void delete(Game game) {

        sessionFactory.inTransaction( session -> session.remove(game) );
    }

}
