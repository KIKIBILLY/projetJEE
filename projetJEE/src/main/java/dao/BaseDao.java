package dao;

public interface BaseDao {
	
	 public boolean login(String username, String password);
	 public String register(User user);

}
