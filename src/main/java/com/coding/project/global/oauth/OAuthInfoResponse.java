package com.coding.project.global.oauth;

import com.coding.project.domain.entitiy.oauth.OAuthProvider;


/*
Access Token으로 요청한 외부 API 프로필 응답값을 서비스의 Model로 변환시키기 위한 인터페이스
카카오 네이버의 email, nickname 정보를 필요로 하기에 Getter 메서드 추가.
*/
public interface OAuthInfoResponse {
    String getEmail();
    String getNickname();
    OAuthProvider getOAuthProvider();
}