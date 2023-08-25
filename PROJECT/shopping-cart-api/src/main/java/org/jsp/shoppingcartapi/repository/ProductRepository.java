package org.jsp.shoppingcartapi.repository;

import java.util.List;

import org.jsp.shoppingcartapi.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query("select p from Product p where p.merchant.id=?1")
	public List<Product> findProductsByMerchantId(int merchant_id);

	@Query("select p from Product p where p.brand=?1")
	public List<Product> findProductsByBrand(String brand);

	@Query("select p from Product p where p.category=?1")
	public List<Product> findProductsByCategory(String category);
}
