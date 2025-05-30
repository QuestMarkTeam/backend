package com.example.cluvrapi.domain.category.entity;

import com.example.cluvrapi.domain.category.enums.CategoryType;
import com.example.cluvrapi.domain.category.enums.CategoryTargetType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "categories")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long targetId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoryType categoryType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoryTargetType targetType;

    public Category(Long targetId, CategoryType categoryType, CategoryTargetType targetType) {
        this.targetId = targetId;
        this.categoryType = categoryType;
        this.targetType = targetType;
    }
}
