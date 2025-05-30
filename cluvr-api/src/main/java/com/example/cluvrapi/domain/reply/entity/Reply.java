package com.example.cluvrapi.domain.reply.entity;

import com.example.cluvrapi.domain.board.entity.Board;
import com.example.cluvrapi.domain.common.entity.BaseTimeEntity;
import com.example.cluvrapi.domain.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

@Entity
@Table(name="replies")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reply extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    //드래곤님 여기는 대댓글용 인데, 맞는지 몰겠어요,,^^
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Reply parent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="board_id")
    private Board board;

    @Column(nullable = false)
    private String content;

    //생성자 -> 대댓글이면 parent에 그 parent답글 넣고, 걍 댓글이면 null 넣는 방식으로 생각해봤어요
    //아니라면 죄삼다.
    public Reply(User user,String content,Board board,Reply parent){
        this.user=user;
        this.content=content;
        this.board=board;
        this.parent=parent;
    }
}
