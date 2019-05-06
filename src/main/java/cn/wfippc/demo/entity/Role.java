package cn.wfippc.demo.entity;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Role implements Serializable{
	private String roleId;
	private String roleName;
	private String status;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date statusDate;
}
