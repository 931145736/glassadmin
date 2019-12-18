package com.xjt.business;

import com.xjt.dto.CustomerReqDto;
import com.xjt.entity.Customer;

public interface CustomerBusinessService {

    void insertCustomer(CustomerReqDto customer);
}
