package com.tiwari.learning.jjwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.tiwari.learning.model.Role;
import com.tiwari.learning.model.User;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getName(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getRoles()),
                true,
                user.getLastPasswordResetDate()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> authorities) {
    	
    	List<GrantedAuthority> grantedAuthorities=new  ArrayList<>();
    	authorities.forEach(role->{
    		grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
    	});
        return grantedAuthorities;
    }
}
