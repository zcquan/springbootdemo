package springboot.service;

import java.util.List;

import springboot.pojo.TbUser;

public interface UserService {

	public String set(String key,String value);
	public String get(String key);
	
	public List<TbUser> findAll();
}
