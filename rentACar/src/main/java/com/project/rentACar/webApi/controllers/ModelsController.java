package com.project.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.rentACar.business.abstracts.ModelService;
import com.project.rentACar.business.requests.CreateModelRequest;
import com.project.rentACar.business.responses.GetAllModelsResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {

	private ModelService modelService;

	@GetMapping()
	public List<GetAllModelsResponse> getAll() {
		return modelService.getAll();
	}

	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED) // 201 döndürdüğünü görmek için
	public void add(@Valid CreateModelRequest createModelRequest) {
		this.modelService.add(createModelRequest);
	}

}
