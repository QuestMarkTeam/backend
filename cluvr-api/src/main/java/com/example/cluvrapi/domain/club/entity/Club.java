package com.example.cluvrapi.domain.club.entity;

import com.example.cluvrapi.domain.club.enums.ClubType;
import com.example.cluvrapi.domain.common.entity.BaseTimeEntity;
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

@Entity
@Getter
@Table(name = "clubs")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Club extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ClubType clubType;

    @Column(nullable = false)
    private int maxMemberCount = 30;

    @Column(nullable = false)
    private int minScoreRequirement = 0;

    @Column(nullable = false)
    private String greeting;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String posterUrl;

    @Column(nullable = false)
    private Boolean isPublic = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Club(String name, ClubType clubType, int maxMemberCount, int minScoreRequirement,
        String greeting, String description, String posterUrl, Boolean isPublic, User user) {
        this.name = name;
        this.clubType = clubType;
        this.maxMemberCount = maxMemberCount;
        this.minScoreRequirement = minScoreRequirement;
        this.greeting = greeting;
        this.description = description;
        this.posterUrl = posterUrl;
        this.isPublic = isPublic;
        this.user = user;
    }
}
