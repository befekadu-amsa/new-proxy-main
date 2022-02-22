package com.amsa.proxy.viewModel.columbiasc;

import lombok.Data;

@Data
public class AddressContact {
    private Integer idNum;
    private String email;
    private String daytimePhone;
    private String mobilePhone;
    private String eveningPhone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String county;
    private String postalCode;
    private String addrCountry;
}
