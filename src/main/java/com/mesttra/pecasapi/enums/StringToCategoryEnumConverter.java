package com.mesttra.pecasapi.enums;

import org.springframework.core.convert.converter.Converter;

public class StringToCategoryEnumConverter implements Converter<String, Category> {
    @Override
    public Category convert(String source) {
        try {
            return Category.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}