package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;
import com.javarush.task.task36.task3608.view.EditUserView;

import java.util.List;

public class MainModel implements Model {
	private ModelData modelData = new ModelData();
	private UserService userService = new UserServiceImpl();
	private EditUserView editUserView = new EditUserView();
	
	@Override
	public ModelData getModelData() {
		return modelData;
	}
	
	@Override
	public void deleteUserById(long id) {
		userService.deleteUser(id);
		loadUsers();
	}
	
	@Override
	public void loadUsers() {
		modelData.setDisplayDeletedUserList(false);
		List<User> users = getAllUsers();
		modelData.setUsers(users);
	}
	
	@Override
	public void loadUserById(long userId) {
		User user = userService.getUsersById(userId);
		modelData.setActiveUser(user);
	}
	
	@Override
	public void loadDeletedUsers() {
		modelData.setDisplayDeletedUserList(true);
		List<User> users = userService.getAllDeletedUsers();
		modelData.setUsers(users);
	}
	
	@Override
	public void changeUserData(String name, long id, int level) {
		userService.createOrUpdateUser(name, id, level);
		loadUsers();
	}
	
	private List<User> getAllUsers() {
		return userService.filterOnlyActiveUsers(userService.getUsersBetweenLevels(1, 100));
	}
}