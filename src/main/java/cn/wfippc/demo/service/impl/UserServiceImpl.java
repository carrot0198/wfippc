package cn.wfippc.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wfippc.demo.dao.UserMapper;
import cn.wfippc.demo.entity.Role;
import cn.wfippc.demo.entity.User;
import cn.wfippc.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> queryAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = userMapper.queryAllUsers();
		return users;
	}

	@Override
	public User queryUserById(String userId) {
		// TODO Auto-generated method stub
		User user = userMapper.queryUserById(userId);
		return user;
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.addUser(user);
	}

	@Override
	public int deleteUser(String userId) {
		// TODO Auto-generated method stub
		return userMapper.deleteUser(userId);
	}

	@Override
	public int modifyUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.modifyUser(user);
	}
	
	@Override
	public List<Role> getUserRoles(String userId) {
		// TODO Auto-generated method stub
		return userMapper.getRoles(userId);
	}
	
}
