package org.eagleinvsys.test.converters.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.eagleinvsys.test.converters.ConvertibleCollection;
import org.eagleinvsys.test.converters.ConvertibleMessage;
import org.eagleinvsys.test.converters.impl.StandardConvertibleCollection;
import org.eagleinvsys.test.converters.impl.StandardConvertibleMessage;


public class ConvertibleCollectionConverter {
    private ConvertibleCollectionConverter(){}

    public static ConvertibleCollection getFromList(List<Map<String, String>> listToConvert) {
        Collection<String> headers = listToConvert.get(0).keySet();
        List<ConvertibleMessage> records = listToConvert.stream()
                                                        .map(StandardConvertibleMessage::new)
                                                        .collect(Collectors.toList());

        return new StandardConvertibleCollection(headers, records);
    }
}
