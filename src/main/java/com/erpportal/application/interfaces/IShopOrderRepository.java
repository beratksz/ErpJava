package com.erpportal.application.interfaces;

import com.erpportal.domain.entities.ShopOrder;
import java.util.List;
import java.util.Optional;

public interface IShopOrderRepository {
    Optional<ShopOrder> findByOrderNo(String orderNo);
    List<ShopOrder> findAll();
    ShopOrder save(ShopOrder shopOrder);
    void deleteByOrderNo(String orderNo);
    boolean existsByOrderNo(String orderNo);
} 