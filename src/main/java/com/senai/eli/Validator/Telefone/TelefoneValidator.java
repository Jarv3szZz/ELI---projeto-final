package com.senai.eli.Validator.Telefone;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TelefoneValidator implements ConstraintValidator<Telefone, String>{

    private boolean apenasCelular;
    private boolean required;

    @Override
    public void initialize(Telefone anotacao){
        this.apenasCelular = anotacao.apenasCelular();
        this.required = anotacao.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
      if (value == null || value.trim().isEmpty()) {
        return !required;
      }

      if (apenasCelular) {
        return value.matches("\\(\\d{2}\\) \\d{5}-\\d{4}");
      }

      return value.matches("\\(\\d{2}) \\d{4,5}-\\d{4}");
    }

}
