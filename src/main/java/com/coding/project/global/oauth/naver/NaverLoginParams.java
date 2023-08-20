package com.coding.project.global.oauth.naver;

import com.coding.project.domain.entitiy.oauth.OAuthProvider;
import com.coding.project.domain.entitiy.oauth.OAuthLoginParams;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;


/* 네이버 API 요청에 필요한 authorizationCode, state를 갖는 클래스 (네이버는 state도 필요로 함)  */
@Getter
@NoArgsConstructor
public class NaverLoginParams implements OAuthLoginParams {
    private String authorizationCode;
    private String state;

    @Override
    public OAuthProvider oAuthProvider() {
        return OAuthProvider.NAVER;
    }

    @Override
    public MultiValueMap<String, String> makeBody() {
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("code", authorizationCode);
        body.add("state", state);
        return body;
    }
}