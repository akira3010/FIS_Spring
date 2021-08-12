package com.fis.springjpa.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fis.springjpa.product.Product;
import com.fis.springjpa.product.ProductRepository;

@RestController // = @Controller + @ResponseBody
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	ProductRepository productRepository;

	@GetMapping("/all")
	public Iterable<Product> getAllEmployees() {
		return productRepository.findAll();
	}

	@PostMapping("/add")
	public String addEmployee(@RequestParam String name) {
		Product product = new Product();
		product.setName(name);
		productRepository.save(product);
		return "Saved";
	}
}
