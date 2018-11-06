package service;

import domain.User;
import repository.UserRepository;
import java.util.UUID;



public class UserService extends UserTools {

    private UserRepository userRepository = new UserRepository();

    public boolean createUser (User user){

        boolean testUser = userTest(user);

        if(testUser == true && (userRepository.checkUserByEmail(user) == false)){
            user.setUserId(UUID.randomUUID().toString());

            String pwd = encryptPassword(user.getPassword());

            if( pwd != null ){
                user.setPassword(pwd);
            } else {
                return false;
            }

            boolean resultCreateUser = userRepository.createUser(user);

            return resultCreateUser;
        }else{
            return false;
        }
    }

    public User getUserById(String userId) {

        User user = null;

        if( userId != null && userId != ""){
            user = userRepository.getUserById(userId);
        }

        return user;
    }


    public User getUserByEmailPwd(String email, String password){

        User recoveredUser = null;

        if(emailCheck(email) == true && password != null){

            password = encryptPassword(password);
            recoveredUser = userRepository.getUserByEmailPwd(email, password);
        }

        return recoveredUser;
    }

    public boolean updateUser(User user){

        boolean testUser = userTest(user);

        if(testUser == true && (userRepository.checkUserByEmail(user) == true)){

            String pwd = encryptPassword(user.getPassword());

            if( pwd != null ){
                user.setPassword(pwd);
            } else {
                return false;
            }

            boolean resultUpdateUser = userRepository.updateUser(user);

            return resultUpdateUser;
        }else{
            return false;
        }
    }
}
