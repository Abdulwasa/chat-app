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

import com.chat.chat.entities.Chat;
import com.chat.chat.repositories.ChatRepository;

@RestController
@RequestMapping("/api")
public class ChatController {

	@Autowired
	ChatRepository chatRepositoriy;
	
	@PostMapping("/create")
	public ResponseEntity<Chat> createChatAccount(@Valid @RequestBody Chat newChatAccount, BindingResult bindingResult){
			if(newChatAccount == null || bindingResult.hasErrors()) {
				return new ResponseEntity<Chat>(HttpStatus.NO_CONTENT);
			}
			chatRepositoriy.save(newChatAccount);
		return new ResponseEntity<Chat>(newChatAccount, HttpStatus.CREATED);
	};
	
	@GetMapping("/all")
	public List<Chat> getChatAccount(){
		return chatRepositoriy.findAll();
	};
}
