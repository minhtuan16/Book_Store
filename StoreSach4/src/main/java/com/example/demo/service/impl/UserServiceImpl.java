//package com.example.demo.service.impl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.dao.UserDao;
//import com.example.demo.entity2.User;
//import com.example.demo.model.UserDTO;
//import com.example.demo.model.UserPrincipal;
//import com.example.demo.service.UserService;
//import com.example.demo.utils.PasswordGenerator;
//
//@Transactional
//@Service
//
//public class UserServiceImpl implements UserService, UserDetailsService {
////public class UserServiceImpl implements UserService {
//	@Autowired
//	private UserDao userDao;
//
//	@Override
//	public void insert(UserDTO userDTO) {
//		User user = new User();
//		user.setName(userDTO.getName());
//		user.setUsername(userDTO.getUsername());
//		user.setPassword(PasswordGenerator.getHashString(userDTO.getPassword()));
////		user.setPassword(userDTO.getPassword());
//		user.setGender(userDTO.getGender());
//		user.setEnabled(userDTO.getEnabled());
//		user.setAddress(userDTO.getAddress());
//		user.setPhone(userDTO.getPhone());
//		user.setAge(userDTO.getAge());
//		user.setRole(userDTO.getRole());
//		user.setEmail(userDTO.getEmail());
//		
//		userDao.insert(user);
//	}
//
//	@Override
//	public void update(UserDTO userDTO) {
//		User user = userDao.get(userDTO.getId());
//		
//		if(user != null) {
//			user.setName(userDTO.getName());
//			user.setUsername(userDTO.getUsername());
//			user.setGender(userDTO.getGender());
//			user.setEnabled(userDTO.getEnabled());
//			user.setAddress(userDTO.getAddress());
//			user.setPhone(userDTO.getPhone());
//			user.setAge(userDTO.getAge());
//			user.setRole(userDTO.getRole());
//			user.setEmail(userDTO.getEmail());
//			
//			userDao.update(user);
//		}
//	}
//
//	@Override
//	public void delete(int id) {
//		
//		User user = userDao.get(id);
//		
//		if(user != null) {
//			userDao.delete(user);
//		}
//	}
//
//	@Override
//	public UserDTO get(int id) {
//
//		User user = userDao.get(id);
//		return convert(user);
//	}
//
//	@Override
//	public UserDTO getByUsername(String username) {
//		User user = userDao.getByUsername(username);
//		return convert(user);
//	}
//
//	@Override
//	public List<UserDTO> search(String name, int start, int length) {
//		List<User> users = userDao.search(name, start, length);
//		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
//		
//		for(User user : users) {
//			userDTOs.add(convert(user));
//		}
//		return userDTOs;
//	}
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userDao.getByUsername(username);
//		
//		if(user == null) {
//			throw new UsernameNotFoundException("not found");
//		}
//		
//		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
//		authorities.add(new SimpleGrantedAuthority(user.getRole()));
//		
//		UserPrincipal userPrincipal = new UserPrincipal(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, authorities);
//		userPrincipal.setId(user.getId());
//		userPrincipal.setName(user.getName());
//		userPrincipal.setPhone(user.getPhone());
//		userPrincipal.setEmail(user.getEmail());
//		
//		return userPrincipal;
//	}
//
//	private UserDTO convert(User user) {
//		UserDTO userDTO = new UserDTO();
//		
//		userDTO.setId(user.getId());
//		userDTO.setName(user.getName());
//		userDTO.setUsername(user.getUsername());
//		userDTO.setGender(user.getGender());
//		userDTO.setEnabled(user.getEnabled());
//		userDTO.setAddress(user.getAddress());
//		userDTO.setPhone(user.getPhone());
//		userDTO.setAge(user.getAge());
//		userDTO.setRole(user.getRole());
//		userDTO.setEmail(user.getEmail());
//		
//		return userDTO;
//	}
//
//	@Override
//	public void changePassword(UserDTO userDTO) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void resetPassword(UserDTO accountDTO) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void setupUserPassword(UserDTO userDTO) {
//		User user = userDao.get(userDTO.getId());
//		if (user != null) {
//			user.setPassword(PasswordGenerator.getHashString(userDTO.getPassword()));
//			userDao.update(user);
//		}
//		
//	}
//
//	@Override
//	public void updateProfile(UserDTO userDTO) {
//		
//	}
//
//}
