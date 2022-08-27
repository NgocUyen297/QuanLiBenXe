package com.uav.service.impl;

import com.uav.pojo.Users;
import com.uav.repository.UserRepository;
import com.uav.service.UserService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@Service("userDetailsService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Override
    public boolean addUser(Users user) {
        String pass = user.getPass();
        user.setPass(this.passwordEncoder.encode(pass));
        user.setRode(Users.USER);
//        user.setCreatedAt(new Date());
        return this.userRepository.addUser(user);
    }

    @Override
    public List<Users> getUser(String username) {
        return this.userRepository.getUser(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Users> users = userRepository.getUser(username);
        if (users.isEmpty()) throw new UsernameNotFoundException("Không tồn tại!");
            Users u = users.get(0);
            
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(u.getRode()));
        
        return new org.springframework.security.core.userdetails
                .User(u.getUsername(), u.getPass(), authorities);
    }
}
