package com.springWeb.WebApplication.Service;

import com.springWeb.WebApplication.Configration.CustomeUserDetailService;
import com.springWeb.WebApplication.Entity.Users;
import com.springWeb.WebApplication.Repositry.UsersRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UsersRep usersRep;
    @Autowired
    PasswordEncoder passwordEncoder;
    public Users createUser(Users users){
        String encodedPassword = passwordEncoder.encode(users.getPassword());
        users.setPassword(encodedPassword);
        return usersRep.save(users);
    }
}
