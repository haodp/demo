package com.demo.model;

import javax.validation.constraints.Size;

import com.sun.istack.internal.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginInputModel implements java.io.Serializable {

    @NotNull
    @Size(min = 8, message = "用户名必须6位以上。")
	String userName;

    @Size(min = 8, message = "密码必须8位以上。")
	String pwd;
}
