package com.stormy.dao;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.stormy.model.User;

public class UserDAOImpl implements UserDAO {
	
	private SessionFactory sf;
	
	public UserDAOImpl(SessionFactory sf){
		this.sf=sf;
	}

	@Override
	public User getUserByCredentials(String username, String password) throws SecurityException {
		
		Session session = sf.openSession();
		Transaction tx = (Transaction) session.beginTransaction();
		Query query = session.createQuery("from com.stormy.model.User where username=:username and password=:password");
		query.setString("username", username);
		query.setString("password", encrypt(password));
		
		User user = (User) query.uniqueResult();
		
		if(user==null){
			System.out.println("Retrieved : "+user);
		}
		
		tx.commit();
		session.close();
		
		return user;
		
	}
	
	public static String encrypt(String source) {
		String md5 = null;
		try {
		MessageDigest mdEnc = MessageDigest.getInstance("MD5"); // Encryption algorithm
		mdEnc.update(source.getBytes(), 0, source.length());
		md5 = new BigInteger(1, mdEnc.digest()).toString(16); // Encrypted string
		} catch (Exception ex) {
		return null;
		}
		return md5;
		}

}
