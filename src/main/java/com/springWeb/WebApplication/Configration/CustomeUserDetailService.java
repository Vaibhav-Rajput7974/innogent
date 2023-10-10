package com.springWeb.WebApplication.Configration;

import com.springWeb.WebApplication.Entity.Users;
import com.springWeb.WebApplication.Repositry.UsersRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomeUserDetailService implements UserDetailsService {

    @Autowired
    private UsersRep usersReposistary;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user=usersReposistary.findByEmail(username);
        System.out.println(user);
        if(user == null){
            throw new UsernameNotFoundException("User Not Found");
        }
        CustomeuserDetails customeuserDetails=new CustomeuserDetails(user);
        return customeuserDetails;
    }
}
