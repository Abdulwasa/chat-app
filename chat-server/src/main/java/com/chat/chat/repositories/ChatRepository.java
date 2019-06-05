package com.chat.chat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chat.chat.entities.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long> {

}
