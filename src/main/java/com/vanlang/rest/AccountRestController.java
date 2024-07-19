package com.vanlang.rest;

import com.vanlang.entity.Account;
import com.vanlang.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/accounts")
public class AccountRestController {

//	@Autowired
//	AccountDAO accountDAO;
	@Autowired
	AccountService accountService;

	@GetMapping
	public List<Account> getAccounts(@RequestParam("admin") Optional<Boolean> admin) {
		if (admin.orElse(false)) {
			return accountService.getAdministrators();
		}
		return accountService.findAll();
	}

	@GetMapping("{id}")
	public Account getOne(@QueryParam("id") String id) {
		return accountService.findById(id);
	}

	@PostMapping("/login")
	public ResponseEntity<?> restLogin(@RequestParam Map<String, String> loginRequest) {
		String username = loginRequest.get("username");
		String password = loginRequest.get("password");

		// Triển khai logic xác thực tài khoản ở đây, sử dụng accountDAO
		// Nếu xác thực thành công, trả về thông tin tài khoản
		// Nếu xác thực thất bại, trả về mã lỗi

		Account authenticatedAccount = accountService.getLogin(username, password);
		if (authenticatedAccount != null) {
			return ResponseEntity.ok(authenticatedAccount);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
		}
	}

	@PostMapping
	public Account create(@RequestBody Account account) {
		return accountService.create(account);
	}

	@PutMapping("{id}")
	public Account update(@PathVariable("id") String id, @RequestBody Account account) {
		return accountService.update(account);
	}

//	@PutMapping("{id}")
//	public void changePassword(@PathVariable("id") String id, @QueryParam ("password")String newPassword,
//			@QueryParam("account")  Account entity) {
//		accountService.changePassword(entity, newPassword);
//	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") String id) {
		accountService.delete(id);
	}
}
