package at.projectX.service.user;

import at.projectX.domain.User;
import at.projectX.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

     @Autowired
     private UserRepository userRepository;

     public List<User> getAllUsers() {
         List<User> users = new ArrayList<>();
         userRepository.findAll().forEach(users::add);
         return users;
     }

     public User getUser(Long id) {
         return userRepository.findById(id).get();
     }

     public void addUser(User user) {
         userRepository.save(user);
     }

     public void updateUser(User user) {
        userRepository.save(user);
     }

     public void deleteUser(Long id) {
       userRepository.deleteById(id);
     }
}
