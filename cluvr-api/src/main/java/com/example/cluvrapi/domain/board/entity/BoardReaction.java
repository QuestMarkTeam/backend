package com.example.cluvrapi.domain.board.entity;

import com.example.cluvrapi.domain.board.enums.ReactionType;
import com.example.cluvrapi.domain.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "board_reactions")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardReaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", nullable = false)
    private Board boardId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReactionType type;

    public BoardReaction(User userId, Board boardId, ReactionType type) {
        this.userId = userId;
        this.boardId = boardId;
        this.type = type;
    }
}
