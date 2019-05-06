package cn.wfippc.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.wfippc.demo.entity.Role;
import cn.wfippc.demo.entity.User;

@Mapper
public interface UserMapper {
	List<User> queryAllUsers();
	User queryUserById(String userId);
	int addUser(User user);
	int deleteUser(String userId);
	int modifyUser(User user);
	List<Role> getRoles(String userId);
}
