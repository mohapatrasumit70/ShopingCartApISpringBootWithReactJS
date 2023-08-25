package org.jsp.shoppingcartapi.repository;

import org.jsp.shoppingcartapi.dto.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
