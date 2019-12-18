package com.xjt.service;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.CustomerReqDto;

public interface CustomerService {

    BaseResDto insertCustomer(CustomerReqDto reqDto);

    BaseResDto queryCustomerInfo(CustomerReqDto reqDto);

    BaseResDto queryCustomerList(CustomerReqDto reqDto);
}
