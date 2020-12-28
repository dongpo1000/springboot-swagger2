package com.pywl.controller;

import com.pywl.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Description: 用户控制层（省略数据层和业务层）
 * <p>
 *
 * @author DongPo
 * @Api 用于类，表示这个类是swagger的资源，tags表示资源标签名称, description标签的描述信息
 * <br/>
 * @ApiOperation() 用于方法，表示一个http请求的操作。value表示操作说明，notes表示详细说明
 * <br/>
 * @ApiParam： 用在请求方法中，描述参数信息 value表示参数的简要说明 required表示是否必传 一般与@RequestParam搭配使用
 * <br/>
 * @ApiImplicitParams： 用在请求的方法上，表示一组参数说明
 * @ApiImplicitParam： 用在@ApiImplicitParams注解中，指定一个请求参数的各个方面。
 * name：参数名，参数名称可以覆盖方法参数名称，value：参数的汉字说明、解释，required：参数是否必须传，默认为false
 * paramType:表示参数类型
 * </p>
 * @date 2020-12 17:46
 */
@RestController
@RequestMapping(path = "/api/user")
@Api(tags = {"用户模块接口"}, description = "包括用户登录等")
public class UserController {

	@ApiOperation(value = "用户登录", notes = "需要传入用户名、密码和验证码")
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(User user,
						@ApiParam(value = "验证码", required = true) @RequestParam String code) {
		System.out.println("接收到的用户信息：" + user);
		System.out.println("接收到的验证码：" + code);
		return "登录成功。Token值为：123456789";
	}

	@ApiOperation(value = "获取当前登录用户信息", notes = "需要将Token放入请求header中")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Token", value = "请求头中的Token", required = true, paramType = "header"),
		@ApiImplicitParam(name = "msg", value = "额外信息")
	})
	@RequestMapping(path = "/findCurrentUser", method = RequestMethod.GET)
	public User findCurrentUser(HttpServletRequest request, String msg) {
		String token = request.getHeader("Token");
		System.out.println("Token的值：" + token);
		System.out.println("额外信息：" + msg);

		User user = new User();
		user.setUserId(1);
		user.setUsername("Tom");
		user.setPassword("123456");

		return user;
	}
}
