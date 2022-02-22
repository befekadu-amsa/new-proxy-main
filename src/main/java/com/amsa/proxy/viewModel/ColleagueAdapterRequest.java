package com.amsa.proxy.viewModel;

import lombok.Data;

@Data
public class ColleagueAdapterRequest {
    private String subroutineName;
    private HttpMethod httpMethod;
    private String payload;
    private String url;
}
