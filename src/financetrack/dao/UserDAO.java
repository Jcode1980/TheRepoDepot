package financetrack.dao;

import java.util.Iterator;
import java.util.*;
import org.hibernate.Session;

import financetrack.HibernateUtil;
import financetrack.common.User;

public class UserDAO {
	/**
	 * Create a new asset or update an existing one
	 * 
	 * @param asset
	 *            asset to be persisted
	 */
	public void saveOrUpdateUser(User user) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.saveOrUpdate(user);
	}

	/**
	 * Retrieve an asset from the data store
	 * 
	 * @param assetId
	 *            identifier of the asset to be retrieved
	 * @return asset represented by the identifier provided
	 */
	public User getUser(long assetId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		User asset = (User) session.get(User.class, assetId);
		return asset;
	}

	public List<User> getAllUsers(){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		return session.createQuery("FROM User").list(); 
	}
	
	/**
	 * Delete asset from data store
	 * 
	 * @param asset
	 *            asset to be deleted
	 */
	public void deleteUser(User asset) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.delete(asset);
	}
}
