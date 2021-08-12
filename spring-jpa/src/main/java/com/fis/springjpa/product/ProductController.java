package com.fis.springjpa.product;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController // = @Controller + @ResponseBody
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductRepository productRepository;

	@GetMapping
	public Iterable<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@PostMapping
//	public String addProduct(@RequestParam String name, @RequestParam double price) {
//		Product product = new Product();
//		product.setName(name);
//		product.setPrice(price);
	public String addProduct(@RequestBody Product product) {
		productRepository.save(product);
		return "Saved";
	}

	@PutMapping
	public String updateProduct(@RequestBody Product product) {
		Optional<Product> p = productRepository.findById(product.getId());
		if (p.isPresent()) {
			productRepository.save(product);
			return "Updated";
		} else {
			return "Product Not Found!!";
		}
	}

	@DeleteMapping
	public String deleteProduct(@RequestParam int id) {
		Optional<Product> p = productRepository.findById(id);
		if (p.isPresent()) {
			productRepository.delete(p.get());
			return "Deleted";
		} else {
			return "Product Not Found!!";
		}
	}

	@GetMapping("/{id}")
	public Object getAProduct(@PathVariable int id) {
		Optional<Product> p = productRepository.findById(id);
		if (p.isPresent()) {
			return p.get();
		} else {
			return "Product Not Found!!";
		}
	}

}
