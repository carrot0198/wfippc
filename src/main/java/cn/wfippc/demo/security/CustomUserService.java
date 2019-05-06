package cn.wfippc.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cn.wfippc.demo.dao.UserMapper;
import cn.wfippc.demo.entity.Role;
import cn.wfippc.demo.entity.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserService implements UserDetailsService { //自定义UserDetailsService 接口

    @Autowired
    UserMapper um;

    @Override
    public UserDetails loadUserByUsername(String userId) { //重写loadUserByUsername 方法获得 userdetails 类型用户

        User user = um.queryUserById(userId);
        if(user == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
        for(Role role:um.getRoles(user.getUserId()))
        {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            //System.out.println(role.getRoleName());
        }
        return new org.springframework.security.core.userdetails.User(user.getUserId(),
                user.getPassword(), authorities);
    }
}
