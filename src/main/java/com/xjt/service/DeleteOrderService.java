package com.xjt.service;

import com.xjt.dto.BaseResDto;
import com.xjt.entity.DeleteOrderEntity;

public interface DeleteOrderService {

    BaseResDto deleteOrder(DeleteOrderEntity entity);
}
