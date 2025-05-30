package com.example.cluvrapi.domain.applicationForm.entity;

import com.example.cluvrapi.domain.club.entity.Club;
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
@Table(name = "applicationForms")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApplicationForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String submissionForm;

    @Column(columnDefinition = "TEXT")
    private String problemForm;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private JoinType joinType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id", nullable = false)
    private Club club;

    public ApplicationForm(String submissionForm, String problemForm, JoinType joinType, User user,
        Club club) {
        this.submissionForm = submissionForm;
        this.problemForm = problemForm;
        this.joinType = joinType;
        this.user = user;
        this.club = club;
    }
}