package com.coding.project.global.oauth.naver;

import com.coding.project.domain.entitiy.oauth.OAuthProvider;
import com.coding.project.global.oauth.OAuthInfoResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


/*
https://developers.naver.com/docs/login/profile/profile.md
https://openapi.naver.com/v1/nid/me 요청 결과값 / 위의 url의 '네이버 회원 프로필 조회 API 명세' 참고
더 많은 응답값이 오지만 필요한 정보만 추려내기 위해 @JsonIgnoreProperties(ignoreUnknown = true) 사용
*/
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class NaverInfoResponse implements OAuthInfoResponse {

    @JsonProperty("response")
    private Response response;

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Response {
        private String email;
        private String nickname;
    }

    @Override
    public String getEmail() {
        return response.email;
    }

    @Override
    public String getNickname() {
        return response.nickname;
    }

    @Override
    public OAuthProvider getOAuthProvider() {
        return OAuthProvider.NAVER;
    }
}