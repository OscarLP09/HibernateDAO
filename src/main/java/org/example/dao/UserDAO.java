package org.example.dao;

import org.example.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAO implements DAO<User> {
    private SessionFactory sessionFactory;
    public UserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    @Override
    public User findById(Long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    public User validateUser(String email, String password){
        try(Session session = sessionFactory.openSession()){
            Query<User> q = session.createQuery("select u from User u where u.email = :email and u.password = :password");
            q.setParameter("email", email);
            q.setParameter("password", password);

            User user = q.uniqueResult();
            User user1 = session.get(User.class, user.getId());
            user1.getGames();

            return user;
        }
    }
}
