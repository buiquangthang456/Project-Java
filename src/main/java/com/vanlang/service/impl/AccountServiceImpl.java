package com.vanlang.service.impl;

import com.vanlang.dao.AccountDAO;
import com.vanlang.dao.AuthorityDAO;
import com.vanlang.dao.RoleDAO;
import com.vanlang.entity.Account;
import com.vanlang.entity.Authority;
import com.vanlang.entity.Role;
import com.vanlang.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDAO adao;
	

	public AccountServiceImpl() {
		super();
	}

	@Autowired
	PasswordEncoder pe;

	@Autowired
	private RoleDAO roleDAO;

	@Autowired
	private AuthorityDAO authorityDAO;
	@Override
	public Account findById(String username) {
		return adao.findById(username).get();
	}

	@Override
	public List<Account> findAll() {
		return adao.findAll();
	}

	@Override
	public List<Account> getAdministrators() {
		return adao.getAdministrators();
	}

	@Override
	public Account create(Account account) {

		// Lưu người dùng
		Account savedAccount = adao.save(account);

		// Lấy vai trò "CUST"
		Role customerRole = roleDAO.findById("CUST")
				.orElseThrow(() -> new RuntimeException("Role not found"));

		// Tạo Authority và gán vai trò cho người dùng
		Authority authority = new Authority();
		authority.setAccount(savedAccount);
		authority.setRole(customerRole);
		authorityDAO.save(authority);

		return adao.save(account);
	}

	@Override
	public Account update(Account account) {
		return adao.save(account);
	}

	@Override
	public void delete(String username) {
		adao.deleteById(username);
	}

	@Override
	public void loginFromOAuth2(OAuth2AuthenticationToken oauth2) {
//  	String fullname = oauth2.getPrincipal().getAttribute("name");
//		String email = oauth2.getPrincipal().getAttribute("email");
//		String password = Long.toHexString(System.currentTimeMillis());
//
//		UserDetails user = User.withUsername(email).password(pe.encode(password)).roles("CUST").build();
//		Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
//		SecurityContextHolder.getContext().setAuthentication(auth);
	}

	@Override
	public void updateToken(String token, String email) throws Exception {
		Account entity = adao.findByEmail(email);
		if (entity != null) {
			entity.setToken(token);
			adao.save(entity);
		} else {
			throw new Exception("Cannot find any account with email: " + email);
		}
	}

	@Override
	public Account getByToken(String token) {
		return adao.findByToken(token);
	}

	@Override
	public void updatePassword(Account entity, String newPassword) {
		entity.setPassword(newPassword);
		entity.setToken("token");
		adao.save(entity);
	}

	@Override
	public void changePassword(Account entity, String newPassword) {
		entity.setPassword(newPassword);
		adao.save(entity);
	}

	@Override
	public Account getLogin(String username, String password) {
		return adao.getAccount(username, password);
		
	}

}
