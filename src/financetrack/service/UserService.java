package financetrack.service;

import financetrack.common.User;
import financetrack.dao.UserDAO;

public class UserService {
	UserDAO userDAO = new UserDAO();

	/**
	 * Create a new user or update an existing one
	 * 
	 * @param user
	 *            user to be persisted
	 */
	public void saveOrUpdateUser(User user) {
		userDAO.saveOrUpdateUser(user);
	}

	/**
	 * Retrieve an user
	 * 
	 * @param userId
	 *            identifier of the user to be retrieved
	 * @return user represented by the identifier provided
	 */
	public User getUser(long userID) {
		return userDAO.getUser(userID);
	}

	/**
	 * Delete user
	 * 
	 * @param user
	 *            user to be deleted
	 */
	public void deleteUser(User user) {
		userDAO.deleteUser(user);
	}
}
