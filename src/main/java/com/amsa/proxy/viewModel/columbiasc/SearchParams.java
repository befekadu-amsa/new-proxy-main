package com.amsa.proxy.viewModel.columbiasc;

import lombok.Data;

@Data
public class SearchParams {
    private long id;
    private Integer searchId;
    private String searchFirstName;
    private String searchLastName;
    private String searchSSN;
    private String searchDateOfBirth;
}
