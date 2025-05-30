package com.example.cluvrapi.global.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
@AllArgsConstructor
public enum ResponseCode {

    /* JSON 결과 */
    OK(HttpStatus.OK, "요청 처리 성공"),
    CREATED(HttpStatus.CREATED, "요청 처리 성공"),
    NO_CONTENT(HttpStatus.NO_CONTENT, "요청 처리 성공"),
    FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "요청 처리 실패"),
    DB_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "요청 DB 처리 실패"),
    VALID_FAIL(HttpStatus.BAD_REQUEST, "유효성 검증에 실패하였습니다."),
    NOT_FOUND(HttpStatus.NOT_FOUND, "NOT FOUND"),

    /* 인증, 인가 */
    LOGIN_FAILED(HttpStatus.UNAUTHORIZED, "아이디(로그인 이메일) 또는 비밀번호가 잘못 되었습니다. 아이디와 비밀번호를 정확히 입력해 주세요."),
    AUTH_ANNOTATION_USER_MISMATCH(HttpStatus.UNAUTHORIZED, "@Auth와 AuthUser 타입은 함께 사용되어야 합니다."),
    AUTHENTICATION_FAILED(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다."),
    ACCESS_DENIED(HttpStatus.FORBIDDEN, "Access Denied."),
    WITHDRAWN_USER_ACCESS(HttpStatus.FORBIDDEN, "탈퇴한 유저는 접근할 수 없습니다."),
    TOKEN_INVALID(HttpStatus.UNAUTHORIZED, "유효하지 않은 토큰입니다."),
    TOKEN_BLACKLISTED(HttpStatus.FORBIDDEN, "다시 로그인 해주세요."),

    /* 서버 */
    UNKNOWN_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "알 수 없는 오류");

    private final HttpStatus status;
    private final String defaultMessage;
}