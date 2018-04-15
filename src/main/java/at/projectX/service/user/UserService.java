package at.projectX.service.user;

import at.projectX.domain.User;
import at.projectX.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService{

     @Autowired
     private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);

        if(user == null) {
            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", s));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });

        UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(user.getUsername(), user.getPassword(), authorities);

        return userDetails;
    }

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
