package com.stormy.actions.users;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.stormy.dao.UserDAO;
import com.stormy.dao.UserDAOImpl;
import com.stormy.model.User;

public class LoginAction implements Action, ModelDriven<User>,ServletContextAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5165769090025541738L;
	private User user = new User();
	private ServletContext ctx;
	
	public String execute() throws Exception{
		
		SessionFactory sessionFactory = (SessionFactory) ctx.getAttribute("SessionFactory");
		UserDAO userDAO = new UserDAOImpl(sessionFactory);
		User userDb = userDAO.getUserByCredentials(user.getUsername(),user.getPassword());
		if(userDb==null)
			return ERROR;
		else{
			user.setEmail(userDb.getEmail());
			user.setId(userDb.getId());
			return SUCCESS;
		}
	}
	
	@Override
	public void setServletContext(ServletContext sctx) {
		this.ctx = sctx;
	}
	@Override
	public User getModel() {
		return user;
	}
	
	
}
