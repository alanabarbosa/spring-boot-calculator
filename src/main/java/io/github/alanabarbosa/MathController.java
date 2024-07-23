package io.github.alanabarbosa;

import org.springframework.web.bind.annotation.*;

import io.github.alanabarbosa.converters.*;
import io.github.alanabarbosa.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {
	
	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(
			@PathVariable String numberOne,
			@PathVariable String numberTwo) throws Exception {
		
		verify(numberOne, numberTwo);		
		return NumberConverter.converteToDouble(numberOne) + NumberConverter.converteToDouble(numberTwo);
	}
	
	@GetMapping("/subtract/{numberOne}/{numberTwo}")
	public Double subtract(
			@PathVariable String numberOne,
			@PathVariable String numberTwo) throws Exception {
		
		verify(numberOne, numberTwo);		
		return NumberConverter.converteToDouble(numberOne) - NumberConverter.converteToDouble(numberTwo);
	}
	
	@GetMapping("/multiply/{numberOne}/{numberTwo}")
	public Double multiply(
			@PathVariable String numberOne,
			@PathVariable String numberTwo) throws Exception {
		
		verify(numberOne, numberTwo);		
		return NumberConverter.converteToDouble(numberOne) * NumberConverter.converteToDouble(numberTwo);
	}
	
	@GetMapping("/divide/{numberOne}/{numberTwo}")
	public Double divide(
			@PathVariable String numberOne,
			@PathVariable String numberTwo) throws Exception {
		
		verify(numberOne, numberTwo);		
		return NumberConverter.converteToDouble(numberOne) / NumberConverter.converteToDouble(numberTwo);
	}
	
	private void verify(String numberOne, String numberTwo) {
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
	}
}
