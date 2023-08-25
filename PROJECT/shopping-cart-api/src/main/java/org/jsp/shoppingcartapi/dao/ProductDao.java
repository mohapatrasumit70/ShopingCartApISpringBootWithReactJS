package org.jsp.shoppingcartapi.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.shoppingcartapi.dto.Product;
import org.jsp.shoppingcartapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
	@Autowired
	private ProductRepository repository;

	public Product saveProduct(Product product) {
		return repository.save(product);
	}

	public Product updateProduct(Product product) {
		return repository.save(product);
	}

	public Optional<Product> findById(int id) {
		return repository.findById(id);
	}

	public void deleteProduct(Integer id) {
		repository.deleteById(id);
	}

	public List<Product> findProductsByMerchantId(int merchant_id) {
		return repository.findProductsByMerchantId(merchant_id);
	}

	public List<Product> findProductsByBrand(String brand) {
		return repository.findProductsByBrand(brand);
	}

	public List<Product> findProductsByCategory(String category) {
		return repository.findProductsByCategory(category);
	}
}
