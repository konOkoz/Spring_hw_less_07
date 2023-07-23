package de.ait.validators.impl;

import de.ait.validators.NameValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NameValidatorImpl implements NameValidator {
    private int minLength;

    public NameValidatorImpl(@Value("${min.name.length}") int minLength) {
        this.minLength = minLength;
    }

    public void validateName (String name){
        if(name.length() < minLength) {
            throw new IllegalArgumentException("Wrong product name");
        }
    }
}
