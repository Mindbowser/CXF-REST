package com.example.rest.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BaseDAO {
	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;
	Session session;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getCurrentSession() {
		session = sessionFactory.getCurrentSession();
		if (session == null) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	public void save(Object obj) {
		session = getCurrentSession();
		session.save(obj);
	}

	public void update(Object obj) {
		session = getCurrentSession();
		session.update(obj);
	}

	public void delete(Object obj) {
		session = getCurrentSession();
		session.delete(obj);
	}

	public Object findById(Class<?> className, int id) {
		session = getCurrentSession();
		return session.get(className, id);
	}
}
