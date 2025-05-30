package com.example.cluvrapi.domain.rank.entity;

import com.example.cluvrapi.domain.rank.eunms.Tier;
import com.example.cluvrapi.domain.user.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "ranks")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Rank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Tier tier;

    private Integer score;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Rank(Tier tier, Integer score, User user) {
        this.tier = tier;
        this.score = score;
        this.user = user;
    }
}
