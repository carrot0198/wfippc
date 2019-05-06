package cn.wfippc.demo.service;

import java.util.List;

import cn.wfippc.demo.entity.Role;
import cn.wfippc.demo.entity.User;

public interface UserService {
	List<User> queryAllUsers();
	User queryUserById(String userId);
	int addUser(User user);
	int deleteUser(String userId);
	int modifyUser(User user);
	List<Role> getUserRoles(String userId);
}
