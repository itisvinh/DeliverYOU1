package com.deliveryou.service.implementations;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.deliveryou.pojo.Role;
import com.deliveryou.pojo.User;
import com.deliveryou.repository.interfaces.RoleRepository;
import com.deliveryou.repository.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service("UserDetailsService")
@Transactional
public class UserServiceImpl implements com.deliveryou.service.interfaces.UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User getUser(String phoneNumber) {
        return userRepository.getUser(phoneNumber);
//        return phoneNumber.equalsIgnoreCase("11111") ?
//                new User() {{
//                    setId(1);
//                    setFirstname("12");
//                    setLastname("carls");
//                    setPhoneNumber("11111");
//                    setPassword("$2a$10$BhOlFIl/qqu2pWDynzWBJehk9qmG/YLF25oVs2aEHOu3k8rBnrXby");
//                    setEmail("he@gmail.com");
//                    setRole(new Role() {{
//                        setName("ROLE_USER");
//                    }});
//                }} : null;
    }

    public User getUser(int id) {
        return userRepository.getUser(id);
    }

    @Override
    @Transactional
    public boolean addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role role = roleRepository.getRole(2);
        user.setRole(role);
        try {
            Map r = cloudinary.uploader().upload(user.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            user.setAvatar((String) r.get("secure_url"));

            return userRepository.addUser(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> getUserList() {
        return userRepository.getUserList();
    }

    @Override
    public boolean updateUser(User user) {
        return userRepository.updateUser(user);
    }

//    @Override
//    @Transactional(readOnly = true)
//    public UserDetails loadUserByPhoneNumber(String phoneNumber) {
//        User user = this.getUser(phoneNumber);
//
//        if (user == null)
//            throw new PhoneNumberNotFoundException("No account is registered with this number");
//
//        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>() {{
//            add(new SimpleGrantedAuthority(user.getRole()));
//        }};
//
//        return new org.springframework.security.core.userdetails.User(user.getPhoneNumber(), user.getPassword(), authorities);
//    }


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        User user = this.getUser(phoneNumber);

        if (user == null)
            throw new UsernameNotFoundException("No account is registered with this number");

        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>() {{
            add(new SimpleGrantedAuthority(user.getRole().getName()));
        }};

        return new org.springframework.security.core.userdetails.User(user.getPhoneNumber(), user.getPassword(), authorities);
    }
}
