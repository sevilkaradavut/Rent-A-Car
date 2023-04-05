package com.project.rentACar.business.abstracts;

import java.util.List;

import com.project.rentACar.business.requests.CreateModelRequest;
import com.project.rentACar.business.responses.GetAllModelsResponse;

public interface ModelService {

	List<GetAllModelsResponse> getAll();

	void add(CreateModelRequest createModelRequest);
}
