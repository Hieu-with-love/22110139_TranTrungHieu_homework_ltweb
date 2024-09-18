package devzeus.com.webapp.services;

import devzeus.com.webapp.models.UserModel;

public interface IUserService {
    UserModel findByUserName(String userName);
    UserModel login(String username, String password);
    void insert(UserModel user);
    boolean register(UserModel user);
    boolean checkExistEmail(String email);
    boolean checkExistUsername(String username);
    boolean checkExistPhone(String phone);
}
