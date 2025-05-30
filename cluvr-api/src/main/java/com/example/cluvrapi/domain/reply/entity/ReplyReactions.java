package com.example.cluvrapi.domain.reply.entity;

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
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
//erd에 unique 걸려있길래 달아놨어여~~~~!!! 아닌거면 지워주세옇ㅎ
@Table(name = "reply_reactions", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"user_id", "reply_id"})
})
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReplyReactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reply_id", nullable = false)
    private Reply reply;

    //enum으로 하실지 아닐지 몰라서 일단은 그냥 string으로 해뒀습니다!
    @Column(nullable = false)
    private String type;

    public ReplyReactions(User user, Reply reply, String type) {
        this.user = user;
        this.reply = reply;
        this.type = type;
    }

}
