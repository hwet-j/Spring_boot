package com.coding.project.global.oauth.kakao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;


/*
https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api#request-token-response
https://kauth.kakao.com/oauth/token 요청 결과값 / 위의 url의 '카카오 로그인 토큰 받기'의 응답값 부분 참고
*/
@Getter
@NoArgsConstructor
public class KakaoTokens {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty("expires_in")
    private String expiresIn;

    @JsonProperty("refresh_token_expires_in")
    private String refreshTokenExpiresIn;

    @JsonProperty("scope")
    private String scope;
}