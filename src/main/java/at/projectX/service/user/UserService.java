package at.projectX.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

     @Autowired
     private UserRepository userRepository;

     public List<User> getAllUsers() {
         // return users;
         List<User> users = new ArrayList<>();
         userRepository.findAll().forEach(users::add);
         return users;
     }

     public User getUser(String id) {
         return userRepository.findById(id).get();
     }

     public void addUser(User user) {
         userRepository.save(user);
     }

     public void updateUser(String id, User user) {
        userRepository.save(user);
     }

     public void deleteUser(String id) {
       userRepository.deleteById(id);
     }
}
