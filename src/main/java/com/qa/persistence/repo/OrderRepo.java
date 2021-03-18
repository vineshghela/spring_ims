package com.qa.persistence.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qa.persistence.domain.Order;

/**
 * @author WeDesignStore 14 Mar 2021
 */

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
	@Modifying
	@Transactional
	@Query(value = "insert into ORDER_LINE (ORDER_ID,PRODUCT_ID) VALUES (:orderid,:productid)", nativeQuery = true)
	void insertOrder_Line(@Param("orderid") int orderid, @Param("productid") int productid);

}
