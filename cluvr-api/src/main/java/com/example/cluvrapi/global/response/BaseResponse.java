package com.example.cluvrapi.global.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> implements Serializable {

    @JsonProperty("result")
    private JSONResult jsonResult; // 응답 상태

    private T data; // 응답 데이터

    private BaseResponse(T data, ResponseCode responseCode) {
        this.jsonResult = JSONResult.success(responseCode);
        this.data = data;
    }

    private BaseResponse(JSONResult jsonResult) {
        this.jsonResult = jsonResult;
        this.data = null;
    }

    public static <T> BaseResponse<T> success(T data, ResponseCode responseCode) {
        return new BaseResponse<>(data, responseCode);
    }

    public static <T> BaseResponse<T> success(ResponseCode responseCode) {
        return new BaseResponse<T>(null, responseCode);
    }

    public static <T> BaseResponse<T> error(ResponseCode responseCode, Exception e) {
        return new BaseResponse<>(JSONResult.failure(responseCode, e));
    }

    public static <T> BaseResponse<T> error(ResponseCode responseCode, String customMessage) {
        return new BaseResponse<>(JSONResult.failure(responseCode, customMessage));
    }
}
