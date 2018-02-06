package com.demo.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.demo.dao.gen.MUserMapper;
import com.demo.dao.gen.TUserRoleMapper;
import com.demo.dao.gen.entity.MUser;
import com.demo.dao.gen.entity.MUserExample;
import com.demo.dao.gen.entity.TUserRole;
import com.demo.dao.gen.entity.TUserRoleExample;
import com.demo.model.LoginOutputModel;

@Service
public class LoginService {

	@Autowired
	private MUserMapper userMapper;

	@Autowired
	private TUserRoleMapper userRoleMapper;

	/**
	 * 画面登陆处理按钮
	 * @param userId 用户ID
	 * @param pwd 密码
	 * @return 登陆结果
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public LoginOutputModel doLogin(String userName, String pwd) throws IllegalAccessException, InvocationTargetException {
		// 电话号码或者登陆ID的检索。
		MUserExample example = new MUserExample();
		MUserExample.Criteria criteria = example.createCriteria();
		criteria.andDeleteFlgEqualTo("0");
		criteria.andPwdEqualTo(pwd);
		criteria.andUserIdEqualTo(userName);


		MUserExample.Criteria criteria2 = example.createCriteria();
		criteria.andDeleteFlgEqualTo("0");
		criteria.andPwdEqualTo(pwd);
		criteria.andMobileEqualTo(userName);
		example.or(criteria2);
		List<MUser> users = userMapper.selectByExample(example);

		LoginOutputModel model = new LoginOutputModel();
		if (CollectionUtils.isEmpty(users)) {
			model.setSuccess(false);
			model.setErrorMessage("用户名或密码错误");
		} else {
			BeanUtils.copyProperties(model, users.get(0));
			model.setSuccess(true);
		}

		// 权限的取得
		TUserRoleExample example1 = new TUserRoleExample();
		TUserRoleExample.Criteria criteria1 = example1.createCriteria();
		criteria1.andUserIdEqualTo(Integer.valueOf(userName));
		List<TUserRole> userRoles = userRoleMapper.selectByExample(example1);
		if (CollectionUtils.isEmpty(userRoles)) {
			model.setSuccess(false);
			model.setErrorMessage("该当用户没有权限操作画面。");
		}
		model.setRoleId(userRoles.get(0).getRoleId());

		return model;
	}



}
