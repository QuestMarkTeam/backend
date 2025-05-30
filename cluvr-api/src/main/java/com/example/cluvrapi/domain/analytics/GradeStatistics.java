package com.example.cluvrapi.domain.analytics;

import com.example.cluvrapi.domain.category.entity.Category;
import com.example.cluvrapi.domain.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "grade_statistics")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GradeStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer score;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public GradeStatistics(Integer score, Category category, User user) {
        this.score = score;
        this.category = category;
        this.user = user;
    }
}
