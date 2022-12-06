package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;


public class Util {
    public static Session getSession() {
        return new Configuration().addAnnotatedClass(User.class).buildSessionFactory().getCurrentSession();
    }
}
