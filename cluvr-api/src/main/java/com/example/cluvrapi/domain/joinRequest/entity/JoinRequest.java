package com.example.cluvrapi.domain.joinRequest.entity;

import com.example.cluvrapi.domain.club.entity.Club;
import com.example.cluvrapi.domain.joinRequest.enums.JoinStatus;
import com.example.cluvrapi.domain.joinRequest.enums.JoinType;
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
@Table(name = "joinRequests")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JoinRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id", nullable = false)
    private Club club;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private JoinStatus joinStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private JoinType joinType;

    @Column(columnDefinition = "TEXT")
    private String submissionText;

    @Column(columnDefinition = "TEXT")
    private String problemAnswer;

    public JoinRequest(User user, Club club, JoinStatus joinStatus, JoinType joinType,
        String submissionText, String problemAnswer) {
        this.user = user;
        this.club = club;
        this.joinStatus = joinStatus;
        this.joinType = joinType;
        this.submissionText = submissionText;
        this.problemAnswer = problemAnswer;
    }
}
