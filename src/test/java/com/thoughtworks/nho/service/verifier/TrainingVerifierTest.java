package com.thoughtworks.nho.service.verifier;

import com.thoughtworks.nho.exception.AttributeCharTypeException;
import com.thoughtworks.nho.exception.AttributeEmptyException;
import com.thoughtworks.nho.exception.AttributeTooLongException;
import org.junit.Test;

public class TrainingVerifierTest {


    @Test(expected = AttributeTooLongException.class)
    public void shouldThrowAttributeTooLongExceptionWhenTitleLengthGreaterThan15() throws AttributeEmptyException, AttributeTooLongException, AttributeCharTypeException {
        String title = "1234567890123456";

        TrainingVerifier.verifyTitle(title);
    }

    @Test(expected = AttributeEmptyException.class)
    public void shouldThrowAttributeEmptyExceptionWhenTitleIsEmpty() throws AttributeTooLongException, AttributeEmptyException, AttributeCharTypeException {
        String title = "";
        TrainingVerifier.verifyTitle(title);
    }

    @Test
    public void shouldHappyPassWhenTitleIncludeChineseAndUnderline() throws AttributeEmptyException, AttributeTooLongException, AttributeCharTypeException {
        String title = "标题123ABC";

        TrainingVerifier.verifyTitle(title);
    }

    @Test(expected = AttributeCharTypeException.class)
    public void shouldAttributeCharTypeExceptionWhenTitleIncludeChineseAndUnderline() throws AttributeEmptyException, AttributeTooLongException, AttributeCharTypeException {
        String title = ",,";

        TrainingVerifier.verifyTitle(title);
    }

    @Test(expected = AttributeEmptyException.class)
    public void shouldThrowAttributeEmptyExceptionWhenDescriptionIsEmpty() throws AttributeTooLongException, AttributeEmptyException {
        TrainingVerifier.verifyDescription(null);
    }


    @Test
    public void shouldThrowAttributeTooLongExceptionWhenTitleLengthGreaterThan300() throws AttributeTooLongException, AttributeEmptyException {
        StringBuilder description = new StringBuilder();
        for (int i = 0, size = 300; i < size; i++) {
            description.append(i);
        }

        TrainingVerifier.verifyDescription(description.toString());
    }


}
