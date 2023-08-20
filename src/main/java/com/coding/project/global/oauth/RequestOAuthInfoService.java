package com.coding.project.global.oauth;

import com.coding.project.domain.entitiy.oauth.OAuthLoginParams;
import com.coding.project.domain.entitiy.oauth.OAuthProvider;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


/*
OAuthApiClient를 사용하는 Service 클래스

KakaoApiClient, NaverApiClient 를 직접 주입받아서 사용하면 중복되는 코드가 많아지지만
List<OAuthApiClient> 를 주입 받아서 Map 으로 만들어두면 간단하게 사용할 수 있습니다.

List<인터페이스> 를 주입받으면 해당 인터페이스의 구현체들이 전부 List 에 담겨온다
*/
@Component
public class RequestOAuthInfoService {
    private final Map<OAuthProvider, OAuthApiClient> clients;

    public RequestOAuthInfoService(List<OAuthApiClient> clients) {
        this.clients = clients.stream().collect(
                Collectors.toUnmodifiableMap(OAuthApiClient::oAuthProvider, Function.identity())
        );
    }

    public OAuthInfoResponse request(OAuthLoginParams params) {
        OAuthApiClient client = clients.get(params.oAuthProvider());
        String accessToken = client.requestAccessToken(params);
        return client.requestOauthInfo(accessToken);
    }
}