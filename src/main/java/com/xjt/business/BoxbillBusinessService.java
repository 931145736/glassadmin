package com.xjt.business;

import com.xjt.entity.Boxbill;
import com.xjt.entity.Boxdetail;

import java.util.List;

public interface BoxbillBusinessService {

    void insertBoxBill(Boxbill boxbill, List<Boxdetail> boxdetails);
}
