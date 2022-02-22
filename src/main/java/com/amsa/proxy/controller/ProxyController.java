package com.amsa.proxy.controller;

import com.amsa.proxy.viewModel.ColleagueAdapterRequest;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.core.env.Environment;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.cert.X509Certificate;

@RestController
@RequestMapping("/colleague")
@RequiredArgsConstructor
public class ProxyController {

    private final RestTemplate restTemplate;

    private final String URL_SUFFIX = "/colleague/adapter/";

    private final String ACCESS_TOKEN = "eyJraWQiOiI1QmZydnZHUHRqdEFkb2dqT0VvSGd4eStCMWVCUWVqek1FVUhVWGVkNVhzPSIsImFsZyI6IlJTMjU2In0.eyJvcmlnaW5fanRpIjoiMjYzZWRiYzktMmM0Yy00OGY5LTg4ODUtN2FmNmQ1OTY4ZTIxIiwic3ViIjoiMDNjNDQwYjEtMjZjMC00NGRkLWFkZTItYzM1ZDczN2Q2YmQwIiwiZXZlbnRfaWQiOiJhOGJkODk0Ny1hODAxLTQ4ZGItOTllMC0yOGY3NGU2ZjJiMTQiLCJ0b2tlbl91c2UiOiJhY2Nlc3MiLCJzY29wZSI6ImF3cy5jb2duaXRvLnNpZ25pbi51c2VyLmFkbWluIiwiYXV0aF90aW1lIjoxNjI2NTQxODA0LCJpc3MiOiJodHRwczpcL1wvY29nbml0by1pZHAudXMtZWFzdC0xLmFtYXpvbmF3cy5jb21cL3VzLWVhc3QtMV9rN2cybUV4SUwiLCJleHAiOjE2MjY1NDU0MDQsImlhdCI6MTYyNjU0MTgwNCwianRpIjoiYmNmNTQzNTEtMjJjMy00NTQ1LTgxMzYtMTE4OTVlZGFiMjY0IiwiY2xpZW50X2lkIjoiMW80ZWZrNjk0cDZvZHQ0YmF0OWxvYW0";

    @PostMapping("{client}/{env}")
    public JsonNode getResult(@PathVariable String client, @PathVariable String env, @RequestBody ColleagueAdapterRequest request, @RequestHeader("access-token") String accessToken) throws Exception {

        if (!accessToken.equals(ACCESS_TOKEN)) {
            throw new Exception("The request has not been applied because it lacks valid authentication credentials for the target resource");
        }

        String requestUrl = request.getUrl();
        
        if (requestUrl == null || requestUrl == "") {
            throw new Exception("No request url is specified for client " + client);
        }

        requestUrl = requestUrl + URL_SUFFIX + env;

        System.out.println(requestUrl);


        if(client.equals("calarts")) {
            TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

            SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                    .loadTrustMaterial(null, acceptingTrustStrategy)
                    .build();

            SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

            CloseableHttpClient httpClient = HttpClients.custom()
                    .setSSLSocketFactory(csf)
                    .build();

            HttpComponentsClientHttpRequestFactory requestFactory =
                    new HttpComponentsClientHttpRequestFactory();

            requestFactory.setHttpClient(httpClient);
            RestTemplate restTemplate = new RestTemplate(requestFactory);

            return restTemplate.postForEntity(requestUrl, request, JsonNode.class).getBody();
        }

        return restTemplate.postForEntity(requestUrl, request, JsonNode.class).getBody();
    }
}
