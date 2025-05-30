package com.example.cluvrapi.domain.analytics;

import com.example.cluvrapi.domain.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "point_statistics")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PointStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer point;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public PointStatistics(Integer point, User user) {
        this.point = point;
        this.user = user;
    }
}
