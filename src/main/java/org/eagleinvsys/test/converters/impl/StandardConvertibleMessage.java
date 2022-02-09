package org.eagleinvsys.test.converters.impl;

import java.util.Map;
import org.eagleinvsys.test.converters.ConvertibleMessage;

public class StandardConvertibleMessage implements ConvertibleMessage {

    private final Map<String, String> elements;

    public StandardConvertibleMessage(Map<String, String> elements) {
        this.elements = elements;
    }

    @Override
    public String getElement(String elementId) {
        return elements.get(elementId);
    }
}
