package de.ait.validators.impl;

import de.ait.validators.CountValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CountValidatorImpl implements CountValidator {
    private final int minCount;
    public CountValidatorImpl(@Value("${min.count.length}") int minCount){
        this.minCount = minCount;
    }
    public void validateCount(int count){
        if(count<minCount){
            throw new IllegalArgumentException("Wrong product count");
        }
    }
}
