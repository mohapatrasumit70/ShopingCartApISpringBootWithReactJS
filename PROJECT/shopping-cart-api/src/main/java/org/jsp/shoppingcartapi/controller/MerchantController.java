package org.jsp.shoppingcartapi.controller;

import org.jsp.shoppingcartapi.dto.Merchant;
import org.jsp.shoppingcartapi.dto.ResponseStructure;
import org.jsp.shoppingcartapi.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin("http://localhost:3000/")
public class MerchantController {
	@Autowired
	private MerchantService service;

	@PostMapping("/merchants")
	public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(@RequestBody Merchant merchant,
			HttpServletRequest request) {
		return service.saveMerchant(merchant, request);
	}

	@GetMapping("/merchants/verify-account")
	public ResponseEntity<ResponseStructure<String>> verifyMerchant(@RequestParam String token) {
		return service.verifyMerchant(token);
	}

	@PostMapping("/merchants/forgot-password")
	public ResponseEntity<ResponseStructure<String>> forgotPassword(@RequestParam String email,
			HttpServletRequest request) {
		return service.sendResetPasswordLink(email, request);
	}

	@PostMapping("/merchants/verify")
	public ResponseEntity<ResponseStructure<Merchant>> verifyUser(@RequestParam String email,
			@RequestParam String password) {
		return service.verifyMerchant(email, password);
	}

	@PutMapping("/merchants")
	public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(@RequestBody Merchant merchant) {
		return service.updateMerchant(merchant);
	}
}
