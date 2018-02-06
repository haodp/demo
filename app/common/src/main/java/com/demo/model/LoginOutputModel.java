package com.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginOutputModel extends BaseModel {

	private static final long serialVersionUID = 1L;
    private Integer id;

    private String userId;

    private String pwd;

    private String nickname;

    private String sex;

    private String openid;

    private String unionid;

    private String authQq;

    private String authWeibo;

    private String mobile;

    private String email;

    private String deleteFlg;

    private Integer roleId;

}
