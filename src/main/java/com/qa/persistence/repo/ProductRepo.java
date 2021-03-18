package com.qa.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.persistence.domain.Product;

/**
 * @author WeDesignStore 14 Mar 2021
 */

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

}
