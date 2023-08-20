package com.coding.project.global.oauth.kakao;

import com.coding.project.domain.entitiy.oauth.OAuthProvider;
import com.coding.project.global.oauth.OAuthInfoResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;



/*
https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api#req-user-info
https://kapi.kakao.com/v2/user/me 요청 결과값 / 위의 url의 '사용자 정보 가져오기' 참고 
더 많은 응답값이 오지만 필요한 정보만 추려내기 위해 @JsonIgnoreProperties(ignoreUnknown = true) 사용
*/
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class KakaoInfoResponse implements OAuthInfoResponse {

    @JsonProperty("kakao_account")
    private KakaoAccount kakaoAccount;

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class KakaoAccount {
        private KakaoProfile profile;
        private String email;
    }

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class KakaoProfile {
        private String nickname;
    }

    @Override
    public String getEmail() {
        return kakaoAccount.email;
    }

    @Override
    public String getNickname() {
        return kakaoAccount.profile.nickname;
    }

    @Override
    public OAuthProvider getOAuthProvider() {
        return OAuthProvider.KAKAO;
    }
}
