package metier;


import com.gurugubelli.pojo.User;

public interface Imetier {
 public boolean login(String username, String password);

 public String registration(User user);
