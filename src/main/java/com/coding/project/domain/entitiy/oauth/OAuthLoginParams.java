package com.coding.project.domain.entitiy.oauth;

import org.springframework.util.MultiValueMap;


/* OAuth 요청을 위한 파라미터 값을 갖는 인터페이스 */
public interface OAuthLoginParams {
    OAuthProvider oAuthProvider();
    MultiValueMap<String, String> makeBody();
}
