package com.vanlang.dao;


import com.vanlang.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {
    @Query(value = "SELECT COALESCE(SUM(od.price), 0) AS totalCount FROM orderdetails od", nativeQuery = true)
    Double getTotalRevenue();
}

