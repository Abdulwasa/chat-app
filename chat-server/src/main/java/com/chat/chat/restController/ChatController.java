package com.chat.chat.restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chat.chat.entities.User;
import com.chat.chat.repositories.UserRepository;

@RestController
@RequestMapping("/api")
public class ChatController {

	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/register")
	public ResponseEntity<User> createChatAccount(@Valid @RequestBody User newChatAccount, BindingResult bindingResult){
			if(newChatAccount == null || bindingResult.hasErrors()) {
				return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
			}
			userRepository.save(newChatAccount);
		return new ResponseEntity<User>(newChatAccount, HttpStatus.CREATED);
	};
	
	@GetMapping("/users")
	public List<User> getChatAccount(){
		return userRepository.findAll();
	};
}
