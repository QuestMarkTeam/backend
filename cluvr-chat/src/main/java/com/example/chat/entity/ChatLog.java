package com.example.chat.entity;

import com.example.cluvrapi.domain.common.entity.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "chat_logs")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long roomId;
    private Long userId;

    @Lob
    private String message;

    private LocalDateTime createdAt;

    public ChatLog(Long roomId, Long userId, String message, LocalDateTime createdAt) {
        this.roomId = roomId;
        this.userId = userId;
        this.message = message;
        this.createdAt = createdAt;
    }
}
