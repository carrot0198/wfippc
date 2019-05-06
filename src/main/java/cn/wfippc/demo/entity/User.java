package cn.wfippc.demo.entity;


import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class User implements Serializable{

	public User(String userId, String userName,String password) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		// TODO Auto-generated constructor stub
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	private String userId;
	private String userName;
	private String password;
	private String mobile;
	private String email;
	private String dept;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date lastLoginDate;
	private String lastLoginIp;
	private String status;
	private int retryTimes;

}
