package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.mapper.test.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userMapper.readUser(username);
		if(user==null) {
			throw new UsernameNotFoundException(username);
		}
		user.setAuthorities(getAuthorities(username));
		return user;
	}
	
	public Collection<GrantedAuthority> getAuthorities(String username) {
        List<String> string_authorities = userMapper.readAuthority(username);
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String authority : string_authorities) {
             authorities.add(new SimpleGrantedAuthority(authority));
        }
        return authorities;
   }

	@Override
	public void createUser(User user) {
		String rawPassword = user.getPassword();
		String encodedPassword = new BCryptPasswordEncoder().encode(rawPassword);
		user.setPassword(encodedPassword);
		userMapper.createUser(user);
		userMapper.createAuthority(user);
	}

	@Override
	public void deleteUser(String username) {
		userMapper.deleteUser(username);
		userMapper.deleteAuthority(username);
	}

	@Override
	public PasswordEncoder passwordEncoder() {
		return this.passwordEncoder;
	}
}
