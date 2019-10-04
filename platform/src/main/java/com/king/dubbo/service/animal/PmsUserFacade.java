package com.king.dubbo.service.animal;

import com.king.dubbo.dto.PmsUserDto;

/**
 * @描述: 用户Dubbo服务接口 .
 * @作者: shenwang
 * @创建时间: 2019-03-31
 * @版本号: V1.0 .
 */
public interface PmsUserFacade {
	/**
	 * 保存用户信息.
	 * @param PmsUserDto
	 */
	public void create(PmsUserDto PmsUserDto);

	/**
	 * 根据ID获取用户信息.
	 * @param userId
	 * @return
	 */
	public PmsUserDto getById(Long userId) ;

	/**
	 * 根据登录名取得用户对象
	 */
	public PmsUserDto findUserByUserNo(String userNo);

	/**
	 * 根据ID删除一个用户，同时删除与该用户关联的角色关联信息. type="1"的超级管理员不能删除.
	 *
	 *            用户ID.
	 */
	public void deleteUserById(Long userId);


	/**
	 * 更新用户信息.
	 * @param user
	 */
	public void update(PmsUserDto user);

	/**
	 * 根据用户ID更新用户密码.
	 *
	 * @param userId
	 * @param newPwd
	 *            (已进行SHA1加密)
	 */
	public void updateUserPwd(Long userId, String newPwd, boolean isTrue);

}
