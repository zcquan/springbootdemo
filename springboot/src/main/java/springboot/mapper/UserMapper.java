package springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import springboot.pojo.TbUser;

@Mapper
public interface UserMapper {

	public List<TbUser> findAll();
	
}
