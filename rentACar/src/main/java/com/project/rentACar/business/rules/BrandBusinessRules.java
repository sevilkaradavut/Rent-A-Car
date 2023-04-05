package com.project.rentACar.business.rules;

import org.springframework.stereotype.Service;

import com.project.rentACar.core.utilities.exceptions.BusinessException;
import com.project.rentACar.dataAccess.abstracts.BrandRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandBusinessRules {

	private BrandRepository brandRepository;

	public void checkIfBrandNameExists(String name) {
		if (this.brandRepository.existsByName(name)) {
			throw new BusinessException("Brand already exists."); // Java exception types.
		}
	}
}
