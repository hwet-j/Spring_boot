package com.coding.project.global.oauth;

import com.coding.project.domain.entitiy.oauth.OAuthLoginParams;
import com.coding.project.domain.entitiy.oauth.OAuthProvider;

/*
OAuth 요청을 위한 Client 클래스

oAuthProvider(): Client 의 타입 반환
requestAccessToken: Authorization Code 를 기반으로 인증 API 를 요청해서 Access Token 을 획득
requestOauthInfo: Access Token 을 기반으로 Email, Nickname 이 포함된 프로필 정보를 획득
*/
public interface OAuthApiClient {
    OAuthProvider oAuthProvider();
    String requestAccessToken(OAuthLoginParams params);
    OAuthInfoResponse requestOauthInfo(String accessToken);
}