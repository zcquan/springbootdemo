package springboot.dao;

public interface UserDao {

	//操作redis接口
	
	//set
	public String set(String key,String value);
	//get
	public String get(String key);
}
