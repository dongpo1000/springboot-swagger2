package com.pywl.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Description 用户实体
 * <p>
 *
 * @author DongPo
 * @ApiModel: 用在类上，用户参数用实体类接收的说明
 * @ApiModelProperty ：用于类的属性或方法上，对其说明
 * </p>
 * @date 2020-12 17:47
 */
@Data
@ApiModel(value = "用户User", description = "用户表对应的实体类")
public class User implements Serializable {
	/**
	 * 版本号
	 */
	private static final long serialVersionUID = 5062677302056367659L;

	/**
	 * 主键
	 */
	@ApiModelProperty(value = "用户id")
	private Integer userId;

	/**
	 * 用户名
	 */
	@ApiModelProperty(value = "用户名")
	private String username;

	/**
	 * 密码
	 */
	@ApiModelProperty(value = "密码")
	private String password;
}
