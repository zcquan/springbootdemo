package springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.dao.UserDao;
import springboot.mapper.UserMapper;
import springboot.pojo.TbUser;
import springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserMapper userMapper;
	
	public String set(String key, String value) {
		String k = userDao.set(key, value);
		return k;
	}

	public String get(String key) {
		String value = userDao.get(key);
		return value;
	}

	@Override
	public List<TbUser> findAll() {
		return userMapper.findAll();
	}

}
