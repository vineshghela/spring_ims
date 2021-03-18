package com.qa.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.persistence.domain.Customer;

/**
 * @author WeDesignStore 14 Mar 2021
 */

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
