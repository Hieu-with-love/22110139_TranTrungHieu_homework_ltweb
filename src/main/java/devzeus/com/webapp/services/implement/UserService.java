package devzeus.com.webapp.services.implement;

import devzeus.com.webapp.daos.IUserDao;
import devzeus.com.webapp.daos.impl.UserDaoImpl;
import devzeus.com.webapp.models.UserModel;
import devzeus.com.webapp.services.IUserService;

public class UserService implements IUserService {
    IUserDao userDao = new UserDaoImpl();

    @Override
    public UserModel findByUserName(String userName) {
        return userDao.findByUsername(userName);
    }

    @Override
    public UserModel login(String username, String password) {
        UserModel user = this.findByUserName(username);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }

    public static void main(String[] args) {
        try{
            IUserService userService = new UserService();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
