package io.github.alanabarbosa.math;

import org.springframework.stereotype.Service;

@Service
public class MathService {

    public Double sum(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }

    public Double subtract(Double numberOne, Double numberTwo) {
       return numberOne - numberTwo;
    }

    public Double multiply(Double numberOne, Double numberTwo) {
       return numberOne * numberTwo;
    }

    public Double divide(Double numberOne, Double numberTwo) {
        return numberOne / numberTwo;
    }

  
}