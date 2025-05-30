package com.example.cluvrapi.domain.notification.entity;

import com.example.cluvrapi.domain.common.entity.BaseTimeEntity;
import com.example.cluvrapi.domain.notification.enums.NotiTargetType;
import com.example.cluvrapi.domain.notification.enums.NotificationType;


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
@Table(name = "notifications")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notification extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "notification_type", length = 50, nullable = false)
    private NotificationType notificationType;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 100)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private NotiTargetType targetType;
    private Long targetId;

    @Column(nullable = false)
    private boolean isRead;

    public Notification(User user, NotificationType notificationType, String title, String content,
        NotiTargetType targetType, Long targetId, boolean isRead) {
        this.user = user;
        this.notificationType = notificationType;
        this.title = title;
        this.content = content;
        this.targetType = targetType;
        this.targetId = targetId;
        this.isRead = isRead;
    }

/**
 * 정적 팩토리 메서드 엔티티 객체 생성용
 */
//    public static Notification of(User user, NotificationType type, String title, String content, String targetType, Long targetId){
//        Notification noti = new Notification();
//        noti.user=user;
//        noti.notificationType=type;
//        noti.title=title;
//        noti.content=content;
//        noti.targetType=targetType;
//        noti.targetId=targetId;
//        noti.isRead=false;
//        return noti;
//    }
}
