package com.example.cluvrapi.domain.board.entity;

import com.example.cluvrapi.domain.category.enums.CategoryType;
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
@Table(name = "boards")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // 전체 카테고리 끌고 왔는데,
    // 나중에 변경하셔야 합니다 ! BoardType 이나 Board category 이런식으로 네이밍하셔야 할 거 같아요 !
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoryType category; // <- 일단 클럽 카테고리로 하긴 했는데... 확인 부탁드립니다. (혹시 몰라 BoardType Enum도 만들어 두긴 함)

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int view;

    @Column(nullable = false)
    private boolean isSelected;

    @Column(nullable = false)
    private int clover;

    public Board(User user, CategoryType category, String title, String content, int view,
        boolean isSelected, int clover) {
        this.user = user;
        this.category = category;
        this.title = title;
        this.content = content;
        this.view = view;
        this.isSelected = isSelected;
        this.clover = clover;
    }
}
