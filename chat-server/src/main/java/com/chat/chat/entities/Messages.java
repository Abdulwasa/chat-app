package com.chat.chat.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Messages {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	private String message;
	
	@JsonIgnoreProperties
	@ManyToOne(cascade = CascadeType.ALL,
			fetch=FetchType.LAZY)
	@JoinColumn
	private Chat chatMessage;

	//end fields
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Chat getChatMessage() {
		return chatMessage;
	}

	public void setChatMessage(Chat chatMessage) {
		this.chatMessage = chatMessage;
	}
}
