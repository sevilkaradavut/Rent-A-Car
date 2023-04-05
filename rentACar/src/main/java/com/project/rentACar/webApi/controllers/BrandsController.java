package com.project.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.rentACar.business.abstracts.BrandService;
import com.project.rentACar.business.requests.CreateBrandRequest;
import com.project.rentACar.business.requests.UpdateBrandRequest;
import com.project.rentACar.business.responses.GetAllBrandsResponse;
import com.project.rentACar.business.responses.GetByIdBrandResponse;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {

	private BrandService brandService;

	@GetMapping("/getall")
	public List<GetAllBrandsResponse> getAll() {
		return brandService.getAll();
	}

	@GetMapping("/{id}")
	public GetByIdBrandResponse getById(@PathVariable int id) {
		return brandService.getById(id);
	}

	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED) // 201 döndürdüğünü görmek için
	public void add(@Valid CreateBrandRequest createBrandRequest) {
		this.brandService.add(createBrandRequest);
	}

	@PutMapping
	public void update(@RequestBody UpdateBrandRequest updateBrandRequest) { // Requestin body sinden okunacak
		this.brandService.update(updateBrandRequest);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.brandService.delete(id);
	}

}
