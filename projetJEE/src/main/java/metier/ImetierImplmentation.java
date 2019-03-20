package metier;


import com.gurugubelli.dao.BaseDao;
import com.gurugubelli.dao.BaseDaoImpl;
import bean.User;

public class ImetierImplmentation implements Imetier {

 private BaseDao loginDao = new BaseDaoImpl();

 @Override
 public boolean login(String username, String password) {
  return loginDao.login(username, password);
 }

 
 
 @Override
 public String registration(User utilisateur)
 {
  return loginDao.register(utilisateur);
 }

 
}