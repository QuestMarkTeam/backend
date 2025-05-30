package com.example.cluvrapi.domain.joinRequest.enums;

public enum JoinStatus {
    PENDING,    // 요청됨 (아직 승인되지 않음)
    APPROVED,   // 승인됨
    REJECTED,   // 거절됨
    CANCELED    // 신청자가 요청 취소함
}
