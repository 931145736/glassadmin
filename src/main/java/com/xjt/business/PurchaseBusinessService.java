package com.xjt.business;

import com.xjt.entity.Purchase;
import com.xjt.entity.Purchasedetail;
import com.xjt.entity.Purchasegoods;

import java.util.List;

public interface PurchaseBusinessService {

    void addPurchaseOrder(Purchase purchase, List<Purchasegoods> purchasegoods, List<Purchasedetail> purchasedetails);

    void deletePurchaseOrder(String purchaseId);
}
