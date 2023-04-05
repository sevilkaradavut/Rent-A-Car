package com.project.rentACar;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.project.rentACar.core.utilities.exceptions.BusinessException;
import com.project.rentACar.core.utilities.exceptions.ProblemDetails;

@SpringBootApplication
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException) {
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		return problemDetails;
	}

	// Model Mapper kullandığımız için uygulama çalışır çalışmaz bizden Model Mapper
	// nesnesi üretmemizi ister yoksa hata verir.
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
