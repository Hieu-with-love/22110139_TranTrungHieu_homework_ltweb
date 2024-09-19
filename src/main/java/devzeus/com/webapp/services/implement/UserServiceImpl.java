package devzeus.com.webapp.services.implement;

import devzeus.com.webapp.daos.IUserDao;
import devzeus.com.webapp.daos.impl.UserDaoImpl;
import devzeus.com.webapp.models.UserModel;
import devzeus.com.webapp.services.IUserService;

public class UserServiceImpl implements IUserService {
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

    @Override
    public void insert(UserModel user) {

    }

    @Override
    public boolean register(UserModel user) {
        if (user.getUsername() == null || user.getEmail() == null){
            return false;
        }
        userDao.insertRegisterUser(user);
        return true;
    }

    @Override
    public boolean checkExistEmail(String email) {
        return userDao.checkExistEmail(email);
    }

    @Override
    public boolean checkExistUsername(String username) {
        return userDao.checkExistUsername(username);
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return userDao.checkExistPhone(phone);
    }

    public static void main(String[] args) {
        try{
            IUserService userService = new UserServiceImpl();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
