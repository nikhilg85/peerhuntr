package com.infodart.peerhuntr.jpa.dao.impl;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.infodart.peerhuntr.jpa.dao.UserDetailsDao;
import com.infodart.peerhuntr.jpa.entity.user.User;
import com.infodart.peerhuntr.jpa.entity.user.UserLogin;
@Repository
public class UserDetailsDaoImpl implements UserDetailsDao {
	@Autowired
	private SessionFactory sessionFactory;
	Session session = null;  
	Transaction tx = null;  		
	@Override
	public User checkUserEmailVarified(String userName) {
		List<User> users = new ArrayList<User>();
		users = sessionFactory.getCurrentSession().createQuery("from User u where u.userLogin.loginId=? and u.emailVerified=?")
				.setParameter(0, userName)
				.setParameter(1, (byte)1).list();
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	} 
	@Override
	public User fetchUser(String userName) {
		List<User> users = new ArrayList<User>();
		users = sessionFactory.getCurrentSession().createQuery("from User u where u.userLogin.loginId=?")
				.setParameter(0, userName).list();
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	} 
	@Override
	public User fetchUserById(int id) {
		List<User> users = new ArrayList<User>();
		users = sessionFactory.getCurrentSession().createQuery("from User u where u.userId=? ")
				.setParameter(0, id).list();
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
			// TODO Auto-generated method stub
		}

	}
	@Override
	public UserLogin findUserByUsername(String userName) {
		// TODO Auto-generated method stub
		return null;
	} 

}
	
	
	

/*	@Override
	public UserLogin findUserByUsername(String userName) {
		List<UserLogin> users = new ArrayList<UserLogin>();
		
				.setParameter(1, (byte)1).list();	
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}
	@Override
	public User checkUserEmailVarified(String userName) {
		List<User> users = new ArrayList<User>();
		users = sessionFactory.getCurrentSession().createQuery("from User u where u.userLogin.loginId=? and u.emailVerified=?")
				.setParameter(0, userName)
				.setParameter(1, (byte)1).list();
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
			// TODO Auto-generated method stub
		}
	} 
	@Override
	public User fetchUser(String userName) {
		List<User> users = new ArrayList<User>();
		users = sessionFactory.getCurrentSession().createQuery("from User u where u.userLogin.loginId=?")
				.setParameter(0, userName).list();
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
			// TODO Auto-generated method stub
		}
	} 
	@Override
	public User fetchUserById(int id) {
		List<User> users = new ArrayList<User>();
		users = sessionFactory.getCurrentSession().createQuery("from User u where u.userId=? ")
				.setParameter(0, id).list();
			return null;
			// TODO Auto-generated method stub
		}

	} 

}
*/