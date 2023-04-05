package com.project.rentACar.business.abstracts;

import java.util.List;

import com.project.rentACar.business.requests.CreateBrandRequest;
import com.project.rentACar.business.requests.UpdateBrandRequest;
import com.project.rentACar.business.responses.GetAllBrandsResponse;
import com.project.rentACar.business.responses.GetByIdBrandResponse;

public interface BrandService {
	List<GetAllBrandsResponse> getAll();

	GetByIdBrandResponse getById(int id);

	void add(CreateBrandRequest createBrandRequest);

	void update(UpdateBrandRequest updateBrandRequest);

	void delete(int id);
}
