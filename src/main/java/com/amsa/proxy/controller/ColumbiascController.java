package com.amsa.proxy.controller;

import com.amsa.proxy.viewModel.columbiasc.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("api/columbiasc")
@RequiredArgsConstructor
public class ColumbiascController {

    private final RestTemplate restTemplate;

    private final String ACCESS_TOKEN = "eyJraWQiOiI1QmZydnZHUHRqdEFkb2dqT0VvSGd4eStCMWVCUWVqek1FVUhVWGVkNVhzPSIsImFsZyI6IlJTMjU2In0.eyJvcmlnaW5fanRpIjoiMjYzZWRiYzktMmM0Yy00OGY5LTg4ODUtN2FmNmQ1OTY4ZTIxIiwic3ViIjoiMDNjNDQwYjEtMjZjMC00NGRkLWFkZTItYzM1ZDczN2Q2YmQwIiwiZXZlbnRfaWQiOiJhOGJkODk0Ny1hODAxLTQ4ZGItOTllMC0yOGY3NGU2ZjJiMTQiLCJ0b2tlbl91c2UiOiJhY2Nlc3MiLCJzY29wZSI6ImF3cy5jb2duaXRvLnNpZ25pbi51c2VyLmFkbWluIiwiYXV0aF90aW1lIjoxNjI2NTQxODA0LCJpc3MiOiJodHRwczpcL1wvY29nbml0by1pZHAudXMtZWFzdC0xLmFtYXpvbmF3cy5jb21cL3VzLWVhc3QtMV9rN2cybUV4SUwiLCJleHAiOjE2MjY1NDU0MDQsImlhdCI6MTYyNjU0MTgwNCwianRpIjoiYmNmNTQzNTEtMjJjMy00NTQ1LTgxMzYtMTE4OTVlZGFiMjY0IiwiY2xpZW50X2lkIjoiMW80ZWZrNjk0cDZvZHQ0YmF0OWxvYW0";
    private final String BASE_URL = "https://payment.columbiasc.edu:3001/";

    @PostMapping("record-match")
    public @ResponseBody List getRecordMatch(@RequestBody SearchParams searchParams, @RequestHeader("access-token") String accessToken) throws Exception {

        if (!accessToken.equals(ACCESS_TOKEN)) {
            throw new Exception("The request has not been applied because it lacks valid authentication credentials for the target resource");
        }

        String requestUrl = BASE_URL + "api/amsa-record-match";

        return restTemplate.postForEntity(requestUrl, searchParams, List.class).getBody();
    }

    @PostMapping("name-master")
    public @ResponseBody List nameMaster(@RequestBody NameMaster nameMaster, @RequestHeader("access-token") String accessToken) throws Exception {

        if (!accessToken.equals(ACCESS_TOKEN)) {
            throw new Exception("The request has not been applied because it lacks valid authentication credentials for the target resource");
        }

        String requestUrl  = BASE_URL + "api/name-master";

        return restTemplate.postForEntity(requestUrl, nameMaster, List.class).getBody();
    }

    @PostMapping("address-contact")
    public @ResponseBody List addressContact(@RequestBody AddressContact addressContact, @RequestHeader("access-token") String accessToken) throws Exception {

        if (!accessToken.equals(ACCESS_TOKEN)) {
            throw new Exception("The request has not been applied because it lacks valid authentication credentials for the target resource");
        }

        String requestUrl  = BASE_URL + "api/address-contact";

        return restTemplate.postForEntity(requestUrl, addressContact, List.class).getBody();
    }

    @PostMapping("biograph-master")
    public @ResponseBody List biographMaster(@RequestBody BiographMaster biographMaster, @RequestHeader("access-token") String accessToken) throws Exception {

        if (!accessToken.equals(ACCESS_TOKEN)) {
            throw new Exception("The request has not been applied because it lacks valid authentication credentials for the target resource");
        }

        String requestUrl  = BASE_URL + "api/biograph-master";

        return restTemplate.postForEntity(requestUrl, biographMaster, List.class).getBody();
    }

    @PostMapping("parent-contact")
    public @ResponseBody List parentContact(@RequestBody ParentContact parentContact, @RequestHeader("access-token") String accessToken) throws Exception {

        if (!accessToken.equals(ACCESS_TOKEN)) {
            throw new Exception("The request has not been applied because it lacks valid authentication credentials for the target resource");
        }

        String requestUrl  = BASE_URL + "api/parent-contact";

        return restTemplate.postForEntity(requestUrl, parentContact, List.class).getBody();
    }

    @PostMapping("candidacy")
    public @ResponseBody List candidacy(@RequestBody Candidacy candidacy, @RequestHeader("access-token") String accessToken) throws Exception {

        if (!accessToken.equals(ACCESS_TOKEN)) {
            throw new Exception("The request has not been applied because it lacks valid authentication credentials for the target resource");
        }

        String requestUrl  = BASE_URL + "api/candidacy";

        return restTemplate.postForEntity(requestUrl, candidacy, List.class).getBody();
    }

    @PostMapping("academic-history")
    public @ResponseBody List academicHistory(@RequestBody AcademicHistory academicHistory, @RequestHeader("access-token") String accessToken) throws Exception {

        if (!accessToken.equals(ACCESS_TOKEN)) {
            throw new Exception("The request has not been applied because it lacks valid authentication credentials for the target resource");
        }

        String requestUrl  = BASE_URL + "api/academic-history";

        return restTemplate.postForEntity(requestUrl, academicHistory, List.class).getBody();
    }
}
