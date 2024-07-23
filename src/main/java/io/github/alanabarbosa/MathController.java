package io.github.alanabarbosa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.github.alanabarbosa.converters.NumberConverter;
import io.github.alanabarbosa.exceptions.UnsupportedMathOperationException;
import io.github.alanabarbosa.math.MathService;

@RestController
public class MathController {
	
	private MathService math = new MathService();
	
	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(
			@PathVariable String numberOne,
			@PathVariable String numberTwo) throws Exception {
		
		verify(numberOne, numberTwo);		
		return math.sum(NumberConverter.converteToDouble(numberOne),
				NumberConverter.converteToDouble(numberTwo));
	}
	
	@GetMapping("/subtract/{numberOne}/{numberTwo}")
	public Double subtract(
			@PathVariable String numberOne,
			@PathVariable String numberTwo) throws Exception {
		
		verify(numberOne, numberTwo);		
		return math.subtract(NumberConverter.converteToDouble(numberOne), 
				NumberConverter.converteToDouble(numberTwo));
	}
	
	@GetMapping("/multiply/{numberOne}/{numberTwo}")
	public Double multiply(
			@PathVariable String numberOne,
			@PathVariable String numberTwo) throws Exception {
		
		verify(numberOne, numberTwo);		
		return math.multiply(NumberConverter.converteToDouble(numberOne), 
				NumberConverter.converteToDouble(numberTwo));
	}
	
	@GetMapping("/divide/{numberOne}/{numberTwo}")
	public Double divide(
			@PathVariable String numberOne,
			@PathVariable String numberTwo) throws Exception {
		
		verify(numberOne, numberTwo);		
		return math.divide(NumberConverter.converteToDouble(numberOne), 
				NumberConverter.converteToDouble(numberTwo));
	}
	
	private void verify(String numberOne, String numberTwo) {
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
	}
}
