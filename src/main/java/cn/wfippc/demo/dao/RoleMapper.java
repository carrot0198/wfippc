package cn.wfippc.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.wfippc.demo.entity.Role;

@Mapper
public interface RoleMapper {
	List<Role> queryAllRoles(String roleName);
	int deleteRole(String RoleId);
	int modifyRole(Role role);
	
}
