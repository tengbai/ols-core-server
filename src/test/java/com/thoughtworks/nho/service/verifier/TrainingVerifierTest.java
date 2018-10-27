package com.thoughtworks.nho.service.verifier;

import com.thoughtworks.nho.AttributeCharTypeException;
import com.thoughtworks.nho.exception.AttributeEmptyException;
import com.thoughtworks.nho.exception.AttributeTooLongException;
import org.junit.Test;

public class TrainingVerifierTest {


    @Test(expected = AttributeTooLongException.class)
    public void shouldThrowAttributeTooLongExceptionWhenTitleLengthGreaterThan15() throws AttributeEmptyException, AttributeTooLongException, AttributeCharTypeException {
        String title = "1234567890123456";

        TrainingVerifier.verityTitle(title);
    }

    @Test(expected = AttributeEmptyException.class)
    public void shouldThrowAttributeEmptyExceptionWhenTitleIsEmpty() throws AttributeTooLongException, AttributeEmptyException, AttributeCharTypeException {
        String title = "";
        TrainingVerifier.verityTitle(title);
    }

    @Test
    public void shouldHappyPassWhenTitleIsChinese() throws AttributeEmptyException, AttributeTooLongException, AttributeCharTypeException {
        String title = "你好";

        TrainingVerifier.verityTitle(title);
    }


}
