package cn.wfippc.demo;

import java.util.Date;
import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.wfippc.demo.entity.Role;
import cn.wfippc.demo.entity.User;
import cn.wfippc.demo.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	private UserService us;
	@Test
	public void testAddUser() {
		User user = new User("guanjianyong","管建勇","123456");
		System.out.println(user);
		int i =us.addUser(user);
	}
	
	@Test
	public void testQueryAllUsers() {
		List<User> users = us.queryAllUsers();
		for (User user:users) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testModifyUsers() {
		User user = us.queryUserById("guanjianyong");
		user.setMobile("18853662545");
		user.setLastLoginDate(new Date());
		us.modifyUser(user);
	}
	@Test
	public void testDeleteUsers() {
		int i = us.deleteUser("guanjianyong");
	}
	@Test
	public void testGetUserRoles() {
		List<Role> role = us.getUserRoles("admin");
		System.out.println(role);
	}
}


