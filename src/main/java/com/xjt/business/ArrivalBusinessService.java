package com.xjt.business;

import com.xjt.entity.Arrival;
import com.xjt.entity.Arrivaldetail;
import com.xjt.entity.Arrivalgoods;

import java.util.List;

public interface ArrivalBusinessService {

    void insertArrivalOrder(Arrival arrival, List<Arrivalgoods> arrivalgoods, List<Arrivaldetail> arrivaldetails);
}
