package com.xjt.business;

import com.xjt.entity.*;

import java.util.List;

public interface PureceiptBusinessService {

    void insertPureceiptOrder(Pureceipt pureceipt, List<Pureceiptgoods> pureceiptgoods, List<Pureceiptdetail> pureceiptdetails);

    void checkPureceiptOrder(Pureceipt pureceipt,List<Stockbatch> stockbatches , List<Stockbatchdetail> stockbatchdetails);
}
