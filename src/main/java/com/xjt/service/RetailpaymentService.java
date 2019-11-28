package com.xjt.service;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.RetailpaymentReqDto;

public interface RetailpaymentService {


    BaseResDto insertPayMent(RetailpaymentReqDto reqDto);
}
