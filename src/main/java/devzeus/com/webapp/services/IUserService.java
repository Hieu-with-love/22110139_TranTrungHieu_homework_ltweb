package devzeus.com.webapp.services;

import devzeus.com.webapp.models.UserModel;

public interface IUserService {
    UserModel findByUserName(String userName);
    UserModel login(String username, String password);
}
