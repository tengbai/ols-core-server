package com.thoughtworks.nho.service.verifier;

import com.thoughtworks.nho.AttributeCharTypeException;
import com.thoughtworks.nho.exception.AttributeEmptyException;
import com.thoughtworks.nho.exception.AttributeTooLongException;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

public class TrainingVerifier {

    private static Pattern chinesePattern = Pattern.compile("[\u4e00-\u9fa5]");

    public static void verityTitle(String title) throws AttributeTooLongException, AttributeEmptyException, AttributeCharTypeException {
        if (StringUtils.isEmpty(title)) throw new AttributeEmptyException();
        if (title.length() > 15) throw new AttributeTooLongException();

        if (!chinesePattern.matcher(title).find()) throw new AttributeCharTypeException();
    }
}
