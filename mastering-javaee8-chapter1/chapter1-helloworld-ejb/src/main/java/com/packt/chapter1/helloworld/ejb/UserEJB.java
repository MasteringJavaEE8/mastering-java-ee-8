package com.packt.chapter1.helloworld.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.packt.javaee.ejbapi.UserEJBAPI;
import com.packt.javaee.exception.MessageException;
import com.packt.javaee.jpa.User;

@Local(UserEJBAPI.class)
@Stateful
public class UserEJB implements UserEJBAPI {

	@PersistenceContext(unitName = "chapter1-helloworld-jpa")
	private EntityManager em;

	@Override
	public void insertUserDetails(String user_name, String user_job_role)
			throws MessageException {
		this.deleteUsers();
		if ((null != user_name && !"".equals(user_name))
				&& ((null != user_job_role && !"".equals(user_job_role)))) {
			User u = new User(user_name, user_job_role);
			em.persist(u);
		} else {

		}

	}

	@Override
	public User getUserDetails() throws MessageException {
		List user = em.createNamedQuery("findUsers").getResultList();
		if (user.size() > 0) {
			User firstUser = (User) user.get(0);

			return firstUser;
		} else {
			throw new MessageException("There was nothing in the database.");
		}

	}

	public void deleteUsers() {
		em.createNamedQuery("deleteUsers").executeUpdate();
	}

}
