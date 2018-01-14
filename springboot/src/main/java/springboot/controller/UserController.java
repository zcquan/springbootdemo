package springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.pojo.TbUser;
import springboot.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/redis/{key}/{value}")
	public String set(@PathVariable String key,@PathVariable String value) {
		String set = userService.set(key,value);
		return set;
		
	}
	
	@RequestMapping("/findAll")
	public List<TbUser>  findAll() {
		List<TbUser> list = userService.findAll();
		return list;
	}
}
